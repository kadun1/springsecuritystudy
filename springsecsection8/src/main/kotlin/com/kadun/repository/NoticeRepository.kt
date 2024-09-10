package com.kadun.repository

import com.kadun.model.Notice
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface NoticeRepository: CrudRepository<Notice, Long> {

    @Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
    fun findAllActiveNotices(): List<Notice>
}
