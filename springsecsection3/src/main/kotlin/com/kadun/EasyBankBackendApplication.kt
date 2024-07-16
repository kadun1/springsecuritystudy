package com.kadun

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EasyBankBackendApplication

fun main(args: Array<String>) {
    runApplication<EasyBankBackendApplication>(*args)
}
