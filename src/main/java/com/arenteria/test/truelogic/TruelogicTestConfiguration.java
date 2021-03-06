package com.arenteria.test.truelogic;

import com.bendb.dropwizard.jooq.JooqFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TruelogicTestConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    @NotNull
    @JsonProperty
    private JooqFactory jooq = new JooqFactory(); // Defaults are acceptable

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @NotNull
    @JsonProperty
    private FlywayFactory flyway;


    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public JooqFactory jooq() {
        return jooq;
    }

    public FlywayFactory flyway() {
        return flyway;
    }

}
