package com.arenteria.test.truelogic;

import com.arenteria.test.truelogic.integration.dao.AuthorDAO;
import com.arenteria.test.truelogic.integration.dao.BookAuthorDAO;
import com.arenteria.test.truelogic.integration.dao.BookDAO;
import com.arenteria.test.truelogic.integration.dao.impl.AuthorDAOImpl;
import com.arenteria.test.truelogic.integration.dao.impl.BookAuthorDAOImpl;
import com.arenteria.test.truelogic.integration.dao.impl.BookDAOImpl;
import com.arenteria.test.truelogic.rest.BookshelfResource;
import com.arenteria.test.truelogic.service.BookshelfService;
import com.arenteria.test.truelogic.service.impl.BookshelfServiceImpl;
import com.bendb.dropwizard.jooq.JooqBundle;
import com.bendb.dropwizard.jooq.JooqFactory;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


public class TruelogicTestApplication extends Application<TruelogicTestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TruelogicTestApplication().run(args);
    }

    @Override
    public String getName() {
        return "TruelogicTest";
    }

    private final JooqBundle<TruelogicTestConfiguration> jooq = new JooqBundle<TruelogicTestConfiguration>() {

        /**
         * Required override to define default DataSourceFactory.
         */
        @Override
        public DataSourceFactory getDataSourceFactory(TruelogicTestConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }

        /**
         * Optional override to define reference name of the default DataSourceFactory.
         * Defaults to "jooq".
         */
        @Override
        public String primaryDataSourceName() {
            return "master";
        }

        @Override
        public JooqFactory getJooqFactory(TruelogicTestConfiguration configuration) {
            return configuration.jooq();
        }
    };


    private final SwaggerBundle<TruelogicTestConfiguration> swaggerBundle = new SwaggerBundle<TruelogicTestConfiguration>() {
        @Override
        protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(TruelogicTestConfiguration configuration) {
            return configuration.swaggerBundleConfiguration;
        }
    };

    private final FlywayBundle<TruelogicTestConfiguration> flyway = new FlywayBundle<TruelogicTestConfiguration>() {
        @Override
        public DataSourceFactory getDataSourceFactory(TruelogicTestConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }

        @Override
        public FlywayFactory getFlywayFactory(TruelogicTestConfiguration configuration) {
            return configuration.flyway();
        }
    };

    @Override
    public void initialize(final Bootstrap<TruelogicTestConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addBundle(swaggerBundle);
        bootstrap.addBundle(jooq);
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(flyway);

    }

    @Override
    public void run(final TruelogicTestConfiguration configuration,
                    final Environment environment) {


        BeanConfig config = new BeanConfig();
        config.setTitle("Swagger Truelogic app");
        config.setVersion("1.0.0");
        config.setResourcePackage("io.swagger.sample.resource");
        config.setScan(true);

        //Bookshelf resource build
        final BookDAO bookDAO = new BookDAOImpl(jooq.getConfiguration());
        final AuthorDAO authorDAO = new AuthorDAOImpl(jooq.getConfiguration());
        final BookAuthorDAO bookAuthorDAO = new BookAuthorDAOImpl(jooq.getConfiguration());
        //final BookDAO bookDAO = new BookMockDAOImpl();
        final BookshelfService bookshelfService = new BookshelfServiceImpl(bookDAO, authorDAO, bookAuthorDAO);
        final BookshelfResource bookshelfResource = new BookshelfResource(bookshelfService);


        environment.jersey().register(bookDAO);


        //Resource registering
        environment.jersey().register(bookshelfResource);
        environment.jersey().register(new ApiListingResource());
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //Configure CORS
        //configureCors(environment);
        List<String> allowedOrigins = new ArrayList<String>('*');
        enableCors(environment, allowedOrigins);
    }

    private void configureCors(Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        //cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");


        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    }

    private void enableCors(Environment environment, List<String> allowedOrigins) {
        FilterRegistration.Dynamic filter = environment.servlets().addFilter("cors", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        // Which hosts are allowed to use the API?
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, String.join(",", allowedOrigins));
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter("allowedHeaders", "*");
        filter.setInitParameter("allowCredentials", "true");
        filter.setInitParameter("exposedHeaders", "Date");
    }


}
