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
@Table(name = "notice_details")
class Notice(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "notice_id")
    var noticeId: Int,

    @Column(name = "notice_summary")
    var noticeSummary: String,

    @Column(name = "notice_details")
    var noticeDetails: String,

    @Column(name = "notic_beg_dt")
    var noticBegDt: Date,

    @Column(name = "notic_end_dt")
    var noticEndDt: Date,

    @Column(name = "create_dt")
    var createDt: Date,

    @Column(name = "update_dt")
    var updateDt: Date

    )
