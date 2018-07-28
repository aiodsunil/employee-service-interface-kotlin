package com.aiod.employee.repository

import com.aiod.employee.model.Employee
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

/**
 * Created by Sunil Yadav on 7/28/2018.
 */
@Repository
interface EmployeesRepository : ReactiveCrudRepository<Employee, String> {
    fun findByName(name: String): Mono<Employee>
}