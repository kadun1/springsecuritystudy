package com.kadun.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Accounts(

    @Column(name = "customer_id")
    val customerId: Int,

    @Id
    @Column(name = "account_number")
    val accountNumber: Long,

    @Column(name = "account_type")
    val accountType: String,

    @Column(name = "branch_address")
    val branchAddress: String,

    @Column(name = "created_dt")
    val createdDt: String,
)
