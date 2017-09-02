package com.feint.kotlinaoptest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinAopTestApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinAopTestApplication::class.java, *args)
}
