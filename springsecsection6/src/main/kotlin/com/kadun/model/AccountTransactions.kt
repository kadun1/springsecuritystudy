package com.kadun.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "account_transactions")
class AccountTransactions(

    @Id
    @Column(name = "transaction_id")
    val transactionId: String,

    @Column(name = "account_number")
    val accountNumber: Long,

    @Column(name = "customer_id")
    val customerId: Long,

    @Column(name = "transaction_dt")
    val transactionDt: Date,

    @Column(name = "transaction_summary")
    val transactionSummary: String,

    @Column(name = "transaction_type")
    val transactionType: String,

    @Column(name = "transaction_amt")
    val transactionAmt: Int,

    @Column(name = "closing_balance")
    val closingBalance: Int,

    @Column(name = "create_dt")
    val createDt: Date
)
