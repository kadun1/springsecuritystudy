package com.kadun.controller

import com.kadun.model.Customer
import com.kadun.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController(
    private val CustomerRepository: CustomerRepository
) {

    @PostMapping("/register")
    fun registerUser(
        @RequestBody customer: Customer
    ): ResponseEntity<String>? {
        var savedCustomer: Customer? = null
        var response: ResponseEntity<String>? = null
        try {
            savedCustomer = CustomerRepository.save(customer)
            if (savedCustomer.id > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED)
                    .body("Given user details are successfully registered")
            }
        } catch (e: Exception) {
            response = ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An exception occured due to ${e.message}")
        }
        return response
    }

}
