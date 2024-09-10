package com.kadun.repository

import com.kadun.model.Loans
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LoansRepository: CrudRepository<Loans, Long> {

    fun findByCustomerIdOrderByStartDtDesc(id: Int): List<Loans>?

}
