package com.kadun.repository

import com.kadun.model.Cards
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CardsRepository: CrudRepository<Cards, Long> {
    fun findByCustomerId(id: Int): List<Cards>?
}
