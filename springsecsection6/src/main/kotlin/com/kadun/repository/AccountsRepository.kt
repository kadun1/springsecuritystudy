package com.kadun.repository

import com.kadun.model.Accounts
import org.springframework.data.repository.CrudRepository

interface AccountsRepository: CrudRepository<Accounts, Long> {
    fun findByCustomerId(customerId: Int): Accounts
}
