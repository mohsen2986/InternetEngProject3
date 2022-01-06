package com.mohsen.demo1.auth.model

import javax.persistence.*

@Entity
@Table(name = "role")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int ,
    var name: String ,
//    @ManyToMany(fetch = FetchType.EAGER)
//    var users: Set<User>
)