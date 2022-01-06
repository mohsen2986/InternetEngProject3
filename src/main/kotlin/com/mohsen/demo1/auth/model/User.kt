package com.mohsen.demo1.auth.model

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0,
    var username: String = "",
    var password: String = "",
    @Transient
    var passwordConfirm: String = "",
    @ManyToMany(fetch = FetchType.EAGER)
    var roles: Set<Role> = setOf(),
//    @OneToMany( mappedBy = "user")
//    var enroll: List<Enroll> = listOf()


    )