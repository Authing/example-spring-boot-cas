package com.authing.cas.authingcas;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 开启CAS @EnableCasClient
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCasClient
public class AuthingCasApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthingCasApplication.class, args);
    }

}
