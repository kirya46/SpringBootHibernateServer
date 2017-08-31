package com.common;

import com.common.config.AppConfig;
import com.common.config.HibernateConfig;
import com.common.config.ServerConfig;
import com.common.config.ServiceConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */

@SpringBootApplication
@ComponentScan
/*
 *   NOTE: In Spring Boot + Spring Data JPA application, to support the JSR310 java.time.* APIs,
 *   we need to register this Jsr310JpaConverters manually.
 */
@EntityScan(basePackageClasses = {Application.class, Jsr310JpaConverters.class})//for jsr310 java 8 java.time.*

public class Application {

    public static void main(String[] args) {


        SpringApplication.run(Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(
                AppConfig.class,
                HibernateConfig.class,
                ServiceConfig.class,
                ServerConfig.class
        );
        ctx.refresh();
    }

}
