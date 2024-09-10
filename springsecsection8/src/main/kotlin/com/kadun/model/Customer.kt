package com.kadun.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.hibernate.annotations.GenericGenerator
import java.util.Date

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var pwd: String,
    var role: String,

    @Column(name = "create_dt")
    var createDt: Date?,

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    var authorities: Set<Authority>
)
