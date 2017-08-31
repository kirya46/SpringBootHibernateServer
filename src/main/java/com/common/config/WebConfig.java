package com.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Kirill Stoianov on 31/08/17.
 */

@Deprecated
//@Configuration
//@ComponentScan
public class WebConfig  {

//    @Bean
//    public WebMvcConfigurerAdapter forwardToIndex() {
//        final WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                // forward requests to /admin and /user to their index.html
////                registry.addViewController("/").setViewName(
////                        "forward:index.html");
////                registry.addViewController("/user").setViewName(
////                        "forward:index.html");
//            }
//        };
//
//
//        return webMvcConfigurerAdapter;
//    }
}
