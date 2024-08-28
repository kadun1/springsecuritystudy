package com.kadun.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.GenericGenerator
import java.util.Date

@Entity
@Table(name = "loans")
class Loans(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "loan_number")
    var loanNumber: Long,

    @Column(name = "customer_id")
    var customerId: Int,

    @Column(name = "start_dt")
    var startDt: Date,

    @Column(name = "loan_type")
    var loanType: String,

    @Column(name = "total_loan")
    var totalLoan: Int,

    @Column(name = "amount_paid")
    var amountPaid: Int,

    @Column(name = "outstanding_amount")
    var outstandingAmount: Int,

    @Column(name = "create_dt")
    var createDt: String
)
