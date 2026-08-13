package br.com.gui.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private final Properties properties = new Properties();

    public DatabaseConfig() {
        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "application.properties não encontrado"
                );
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Erro ao carregar application.properties",
                    e
            );
        }
    }

    public String getUrl() {
        return properties.getProperty("db.url");
    }

    public String getUsername() {
        return properties.getProperty("db.username");
    }

    public String getPassword() {
        return properties.getProperty("db.password");
    }
}
