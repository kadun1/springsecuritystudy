package com.kadun.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "contact_messages")
class Contact(
    
    @Id
    @Column(name = "contact_id")
    var contactId: String,
    
    @Column(name = "contact_name")
    var contactName: String,
    
    @Column(name = "contact_email")
    var contactEmail: String,
    
    var subject: String,
    
    @Column(name = "create_dt")
    var createDt: Date,
)
