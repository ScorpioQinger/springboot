package com.scorpiospace.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404page = new ErrorPage(HttpStatus.NOT_FOUND,"/error/404");
        ErrorPage error500page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500");
        registry.addErrorPages(error404page,error500page);
    }
}
