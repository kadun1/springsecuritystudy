package com.kadun.controller

import com.kadun.model.AccountTransactions
import com.kadun.repository.AccountTransactionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BalanceController {

    @Autowired
    private lateinit var accountTransactionsRepository: AccountTransactionsRepository

    @GetMapping("/myBalance")
    fun getBalanceDetails(@RequestParam id: Int): List<AccountTransactions>? {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id)
    }
}
