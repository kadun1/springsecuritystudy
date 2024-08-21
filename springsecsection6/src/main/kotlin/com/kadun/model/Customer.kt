package com.kadun.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator

@Entity
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "customer_id")
    var id: Int,
    var name: String,
    var email: String,
    @Column(name = "mobile_number")
    var mobileNumber: String,
    var pwd: String,
    var role: String,
    @Column(name = "create_dt")
    var createDt: String,

    )
