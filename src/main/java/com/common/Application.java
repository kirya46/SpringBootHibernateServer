package com.common;

import com.common.config.AppMainConfig;
import com.common.config.HibernateConfig;
import com.common.config.ServerConfig;
import com.common.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {


        SpringApplication.run(Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(
                AppMainConfig.class,
                HibernateConfig.class,
                ServiceConfig.class,
                ServerConfig.class
        );
        ctx.refresh();
    }

}
