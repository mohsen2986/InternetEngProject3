package com.mohsen.demo1.auth.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.*
import javax.persistence.Id
import javax.persistence.Table

@Entity
data class Term(
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: Int = 0 ,
    var date: String =""
)