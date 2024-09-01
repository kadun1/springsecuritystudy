package com.kadun.controller

import com.kadun.model.Cards
import com.kadun.repository.CardsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CardsController {

    @Autowired
    private lateinit var cardsRepository: CardsRepository

    @GetMapping("/myCards")
    fun getCardDetails(@RequestParam id: Int): List<Cards>? {
        return cardsRepository.findByCustomerId(id)
    }
}
