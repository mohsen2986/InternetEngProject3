package com.mohsen.demo1.auth.model

import java.time.OffsetDateTime
import java.util.*
import javax.persistence.*
import javax.persistence.GenerationType.*

@Entity
data class TermConfiguration(
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: Int = 0,
    @Temporal(TemporalType.TIMESTAMP)
    var unitSelectionInterval: Date = Date(),
    @Temporal(TemporalType.TIMESTAMP)
    var unitSelectionIntervalEnd: Date = Date(),
    @OneToOne
    var term: Term = Term()
)