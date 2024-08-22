package com.kadun.repository

import com.kadun.model.Contact
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository : CrudRepository<Contact, String>
