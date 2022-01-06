package com.mohsen.demo1.auth.model

import javax.persistence.*
import javax.persistence.GenerationType.*

@Entity
@Table(name = "lessons")
data class Lesson(
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: Int = 0,
    var name: String = "" ,
    @OneToOne
    var user: User = User() ,
//    @OneToMany(mappedBy = "lesson")
//    var enroll: Set<Enroll> = mutableSetOf()
//    @OneToMany
//    var mettings: List<Metting>  = arrayListOf()
)

data class Mark(
    var id: String ,
    var mark: String
)