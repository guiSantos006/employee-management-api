package br.com.gui.config;

import org.flywaydb.core.Flyway;

public class FlywayConfig {

    public static void migrate(){

        var config =  new DatabaseConfig();

        Flyway.configure()
                .dataSource(
                        config.getUrl(),
                        config.getUsername(),
                        config.getPassword()
                )
                .load()
                .migrate();
    }
}
