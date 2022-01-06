package com.mohsen.demo1.auth.model

import javax.persistence.*

@Entity
data class Meeting(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int ,
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    var lesson: Lesson ,
    var day: Int ,
    var time: String = ""
)

enum class Day(val day: Int) {
    Sunday(0),
    Monday(1) ,
    Tuesday(2) ,
    Wednesday(3) ,
    Thursday(4) ,
    Friday(5) ,
    SATURDAY(6)
}