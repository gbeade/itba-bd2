package com.redmond.bankapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@OpenAPIDefinition(
    info = Info(
        title = "Redmond Bank API",
        version = "1.0.0",
        description = "API for Redmond Banks"
    ),
    servers = [
        Server(
            url = "/",
            description = "Local server"
        )
    ]
)
@EnableJpaRepositories("com.redmond.bankapi.repositories.jpa")
@EnableTransactionManagement
@SpringBootApplication
class RedmondBankApiApplication

fun main(args: Array<String>) {
    runApplication<RedmondBankApiApplication>(*args)
}
