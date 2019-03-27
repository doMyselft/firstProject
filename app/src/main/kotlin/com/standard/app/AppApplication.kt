package com.standard.app

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.standard.app.mapper")
class AppApplication

fun main(args: Array<String>) {
	runApplication<AppApplication>(*args)
}
