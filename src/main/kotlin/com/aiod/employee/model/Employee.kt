package com.aiod.employee.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by Sunil Yadav on 7/28/2018.
 */
@Document
data class Employee(@Id val id: String? = null,
                    val name: String,
                    val age: String)