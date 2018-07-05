package com.github.richterplus.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        //对所有非health的actuator endpoint设置http基本认证

        return http
                .authorizeExchange()
                .pathMatchers("/actuator/health").permitAll()
                .pathMatchers("/actuator/**").authenticated()
                .pathMatchers("/**").permitAll()
                .and().httpBasic()
                .and().csrf().disable()
                .build();
    }
}
