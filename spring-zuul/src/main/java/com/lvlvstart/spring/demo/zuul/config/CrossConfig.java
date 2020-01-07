package com.lvlvstart.spring.demo.zuul.config;

import com.google.common.collect.Lists;
import com.netflix.config.sources.URLConfigurationSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域策略
 */
@Configuration
public class CrossConfig {


    @Bean
    public CorsFilter corsFilter(){

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowCredentials(true); //允许cookie等
        configuration.setAllowedOrigins(Lists.newArrayList("*")); // 设置允许的源
        configuration.setAllowedHeaders(Lists.newArrayList("*")); // 允许所有头信息
        configuration.setAllowedMethods(Lists.newArrayList("*")); //允许所有方法，POST GET ...
        configuration.setMaxAge(1000L); //缓存时间，这段时间不重复检查

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return  new CorsFilter(source);



    }


}
