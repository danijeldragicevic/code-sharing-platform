package com.devdan.platform.configs;

import com.devdan.platform.mappers.impl.ModelMapperImpl;
import com.devdan.platform.utils.Util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    ModelMapperImpl modelMapper() {
        return new ModelMapperImpl();
    }
    
    @Bean
    Util util() {
        return new Util();
    }
}
