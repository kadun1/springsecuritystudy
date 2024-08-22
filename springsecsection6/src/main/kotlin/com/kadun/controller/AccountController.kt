package com.kadun.controller

import com.kadun.model.Accounts
import com.kadun.repository.AccountsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController {

    @Autowired
    private lateinit var accountsRepository: AccountsRepository

    @GetMapping("/myAccount")
    fun getAccountDetails(@RequestParam id: Int): Accounts? {
        return accountsRepository.findByCustomerId(id)
    }
}
