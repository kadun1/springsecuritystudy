package com.kadun

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
//@EnableWebSecurity // Spring Boot 에서는 어노테이션이 없어도 기본적인 보안 설정이 적용된다.
class EasyBankBackendApplication

fun main(args: Array<String>) {
    runApplication<EasyBankBackendApplication>(*args)
}
