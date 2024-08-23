package com.kadun.controller

import com.kadun.model.Loans
import com.kadun.repository.LoansRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LoansController {

    @Autowired
    private lateinit var loansRepository: LoansRepository

    @GetMapping("/myLoans")
    fun getLoanDetails(@RequestParam id: Int): List<Loans>? {
        return loansRepository.findByCustomerIdOrderByStartDtDesc(id)
    }
}
