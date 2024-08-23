package com.kadun.controller

import com.kadun.model.Notice
import com.kadun.repository.NoticeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.CacheControl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@RestController
class NoticesController {

    @Autowired
    private lateinit var noticeRepository: NoticeRepository

    @GetMapping("/notices")
    fun getNotices(): ResponseEntity<List<Notice>>? {
        val notices = noticeRepository.findAllActiveNotices()
        return ResponseEntity.ok()
            .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
            .body(notices)
    }
}
