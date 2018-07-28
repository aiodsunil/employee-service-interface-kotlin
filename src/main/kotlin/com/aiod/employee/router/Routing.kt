package com.aiod.employee.router


import com.aiod.employee.handler.EmployeesHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class Routing {

    @Bean
    fun EmployeesRouter(handler: EmployeesHandler) = router {
        ("/employees" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/", handler::getAll)
            GET("/{name}", handler::getEmployee)
            POST("/", handler::addEmployee)
        }
    }

}