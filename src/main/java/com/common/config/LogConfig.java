package com.common.config;

import com.common.util.log.Log4jConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kirill Stoianov on 04/09/17.
 */

@Configuration
public class LogConfig {

    @Bean
    public Log4jConfig configureLog4j(){
        return new Log4jConfig();
    }
}
