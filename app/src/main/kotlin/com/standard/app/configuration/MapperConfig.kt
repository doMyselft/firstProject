package com.standard.app.configuration

import com.standard.app.interceptor.MybatisInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class MapperConfig {
    @Bean
    fun mybatisInterceptor(): MybatisInterceptor {
        var mybatisInterceptor = MybatisInterceptor()
        var properties = Properties()
        properties["time"] = 1
        mybatisInterceptor.setProperties(properties)
        return mybatisInterceptor
    }
}