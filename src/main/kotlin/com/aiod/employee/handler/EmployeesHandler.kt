package com.aiod.employee.handler


import com.aiod.employee.model.Employee
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.time.Duration
import  com.aiod.employee.repository.EmployeesRepository



@Component
class EmployeesHandler(private val repository: EmployeesRepository) {

    fun getAll(request: ServerRequest): Mono<ServerResponse> {
        val interval = Flux.interval(Duration.ofSeconds(1))

        val employees = repository.findAll()
        return ok().bodyToServerSentEvents(Flux.zip(interval, employees).map({ it.t2 }))
    }

    fun getEmployee(request: ServerRequest): Mono<ServerResponse> {
        val name = request.pathVariable("name")

        return ok().body(repository.findByName(name))
    }

    fun addEmployee(request: ServerRequest): Mono<ServerResponse> {
        val employee = request.bodyToMono<Employee>()

        return ok().body(repository.saveAll(employee).toMono())
    }
}

