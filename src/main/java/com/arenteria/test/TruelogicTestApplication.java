package com.arenteria.test;

import com.arenteria.test.config.DatasourceConfig;
import com.arenteria.test.domain.mapper.BookMapper;
import com.arenteria.test.integration.dao.BookDAO;
import com.arenteria.test.integration.dao.impl.BookDAOImpl;
import com.arenteria.test.rest.BookshelfResource;
import com.arenteria.test.service.BookshelfService;
import com.arenteria.test.service.impl.BookshelfServiceImpl;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;
import org.jooq.Configuration;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultRecordMapperProvider;
import org.sqlite.SQLiteConfig;


public class TruelogicTestApplication extends Application<TruelogicTestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TruelogicTestApplication().run(args);
    }

    @Override
    public String getName() {
        return "TruelogicTest";
    }

    @Override
    public void initialize(final Bootstrap<TruelogicTestConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(final TruelogicTestConfiguration configuration,
                    final Environment environment) {

        DefaultConfiguration dbConf = new DefaultConfiguration();
        dbConf.setDataSource(DatasourceConfig.createDatasource());

        final BookDAO bookDAO = new BookDAOImpl(dbConf);
        final BookMapper bookMapper = new BookMapper();
        final BookshelfService bookshelfService = new BookshelfServiceImpl(bookDAO, bookMapper);
        final BookshelfResource bookshelfResource = new BookshelfResource(bookshelfService);

        environment.jersey().register(bookshelfResource);
    }

}
