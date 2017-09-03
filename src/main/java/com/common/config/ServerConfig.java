package com.common.config;

import com.common.controller.AppErrorController;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.Server;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Kirill Stoianov on 28/08/17.
 */
@Configuration
public class ServerConfig {

    private InetAddress host;
    private int port;

    public ServerConfig() {
        try {
            this.host = InetAddress.getByName("localhost");
//            this.host = InetAddress.getByName("192.168.0.101");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        this.port = 8080;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setAddress(ServerConfig.this.host);
                container.setPort(ServerConfig.this.port);
                //container.setContextPath(); // localhost:8080/api/test/{your_rest_method}
            }
        };
    }

    @Bean
    public InternalResourceViewResolver resourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    //START DEFAULT ERROR CONTROLLER
    @Autowired(required=false)
    private DefaultErrorAttributes errorAttributes;

    @Bean
    public AppErrorController appErrorController(){return new AppErrorController(errorAttributes);}
    //END DEFAULT ERROR CONTROLLER

}
