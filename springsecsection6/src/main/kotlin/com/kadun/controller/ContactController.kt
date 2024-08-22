package com.kadun.controller

import com.kadun.model.Contact
import com.kadun.repository.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.Date
import kotlin.random.Random

@RestController
class ContactController {

    @Autowired
    private lateinit var contactRepository: ContactRepository

    @PostMapping("/contact")
    fun saveContactInquiryDetails(@RequestBody contact: Contact): Contact {
        contact.contactId = getServiceReqNumber()
        contact.createDt = Date(System.currentTimeMillis())
        return contactRepository.save(contact)
    }

    fun getServiceReqNumber(): String {
        val random = Random.nextInt(999999999 - 9999) * 9999;
        return "SR$random"
    }

//    @GetMapping("/contact")
//    fun getContactDetails(): String {
//        return "Here are the account details from the DB"
//    }
}
