package com.github.richterplus.monitor.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnConsulEnabled
@EnableDiscoveryClient
class ConsulConfig {
}
