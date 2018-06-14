package com.arenteria.test.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class DatasourceConfig {

    private DatasourceConfig(){}

    public static DataSource createDatasource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:truelogic.db");
        config.setAutoCommit(true);
        config.setMaximumPoolSize(32);
        config.setDriverClassName("org.sqlite.JDBC");
        return new HikariDataSource(config);
    }
}
