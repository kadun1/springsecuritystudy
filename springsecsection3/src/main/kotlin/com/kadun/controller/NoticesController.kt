package com.kadun.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NoticesController {

    @GetMapping("/notices")
    fun getNotices(): String {
        return "Here are the notices from the DB"
    }
}
