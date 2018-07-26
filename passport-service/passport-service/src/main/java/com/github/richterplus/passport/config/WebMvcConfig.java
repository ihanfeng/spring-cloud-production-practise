package com.github.richterplus.passport.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
class WebMvcConfig {

    @Bean
    public WebMvcRegistrations feignWebRegistrations() {
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new RequestMappingHandlerMapping() {
                    @Override
                    protected boolean isHandler(Class<?> beanType) {
                        return super.isHandler(beanType) && (AnnotationUtils.findAnnotation(beanType, FeignClient.class) == null);
                    }
                };
            }
        };
    }
}
