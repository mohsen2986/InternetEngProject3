package com.mohsen.demo1.auth.service

import com.mohsen.demo1.auth.model.User


interface UserService{
    fun save(user: User)
    fun findByUserName(username: String): User?
}