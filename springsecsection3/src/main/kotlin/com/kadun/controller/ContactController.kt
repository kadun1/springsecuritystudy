package com.kadun.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContactController {

    @GetMapping("/contact")
    fun getContactDetails(): String {
        return "Here are the account details from the DB"
    }
}
