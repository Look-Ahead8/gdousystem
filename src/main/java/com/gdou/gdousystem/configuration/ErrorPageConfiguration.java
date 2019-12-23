package com.gdou.gdousystem.configuration;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Meng
 * @date 2019/12/21
 */
@Configuration
public class ErrorPageConfiguration {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return (factory->{
            Set<ErrorPage> errorPageSet=new HashSet<>();
            errorPageSet.add(new ErrorPage(HttpStatus.NOT_FOUND,"/error/404.html"));
            errorPageSet.add(new ErrorPage(HttpStatus.UNAUTHORIZED,"/error/401.html"));
            errorPageSet.add(new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED,"/error/405.html"));
            errorPageSet.add(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500.html"));
            factory.setErrorPages(errorPageSet);
        });
    }
}
