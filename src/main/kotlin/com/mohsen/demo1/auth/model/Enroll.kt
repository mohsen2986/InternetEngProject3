package com.mohsen.demo1.auth.model

import javax.persistence.*

@Entity
data class Enroll(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int  = 0,
    var mark: Int = 0,
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User = User(),
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    var lesson: Lesson = Lesson()
)
data class MeetObj(
    var day: String ,
    var time: String,
    var lesson: String
)