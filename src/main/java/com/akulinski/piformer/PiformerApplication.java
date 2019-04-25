package com.akulinski.piformer;

import com.akulinski.piformer.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class PiformerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiformerApplication.class, args);
    }

}
