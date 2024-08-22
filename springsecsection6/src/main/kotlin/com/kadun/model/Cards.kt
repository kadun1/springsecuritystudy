package com.kadun.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "cards")
class Cards(
    @Id
    @Column(name = "card_id")
    var cardId: Long,
    
    @Column(name = "customer_id")
    var customerId: Long,
    
    @Column(name = "card_number")
    var cardNumber: String,
    
    @Column(name = "card_type")
    var cardType: String,
    
    @Column(name = "total_limit")
    var totalLimit: Int,
    
    @Column(name = "amount_used")
    var amountUsed: Int,
    
    @Column(name = "available_mount")
    var availableAmount: Int,
    
    @Column(name = "create_dt")
    var createDt: Date
)
