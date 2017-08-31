package com.common.config;

import com.common.service.impl.AvatarService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Kirill Stoianov on 30/08/17.
 */

@Configuration

/**
 * enable defining implementation of interfaces as Bean (GenericDao implementation)
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class ServiceConfig {

//    @Bean
    public AvatarService getUserService(){
        return new AvatarService();
    }
}
