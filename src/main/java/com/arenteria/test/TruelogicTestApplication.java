package com.arenteria.test;

import com.arenteria.test.domain.mapper.BookMapper;
import com.arenteria.test.integration.dao.BookDAO;
import com.arenteria.test.integration.dao.impl.BookDAOImpl;
import com.arenteria.test.integration.dao.impl.BookMockDAOImpl;
import com.arenteria.test.rest.BookshelfResource;
import com.arenteria.test.service.BookshelfService;
import com.arenteria.test.service.impl.BookshelfServiceImpl;
import com.bendb.dropwizard.jooq.JooqBundle;
import com.bendb.dropwizard.jooq.JooqFactory;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;


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
    }

    @Override
    public void run(final TruelogicTestConfiguration configuration,
                    final Environment environment) {


        BeanConfig config = new BeanConfig();
        config.setTitle("Swagger sample app");
        config.setVersion("1.0.0");
        config.setResourcePackage("io.swagger.sample.resource");
        config.setScan(true);

        final BookDAO bookDAO = new BookDAOImpl(jooq.getConfiguration());
        //final BookDAO bookDAO = new BookMockDAOImpl();
        final BookMapper bookMapper = new BookMapper();
        final BookshelfService bookshelfService = new BookshelfServiceImpl(bookDAO, bookMapper);
        final BookshelfResource bookshelfResource = new BookshelfResource(bookshelfService);

        environment.jersey().register(bookshelfResource);
        environment.jersey().register(new ApiListingResource());
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

    }

}
