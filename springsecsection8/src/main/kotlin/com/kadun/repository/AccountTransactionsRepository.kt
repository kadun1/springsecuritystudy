package com.kadun.repository

import com.kadun.model.AccountTransactions
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountTransactionsRepository: CrudRepository<AccountTransactions, Long> {
    fun findByCustomerIdOrderByTransactionDtDesc(customerId: Int): List<AccountTransactions>
}
