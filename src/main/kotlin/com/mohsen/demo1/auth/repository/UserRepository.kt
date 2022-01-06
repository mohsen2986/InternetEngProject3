package com.mohsen.demo1.auth.repository

import com.mohsen.demo1.auth.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>{
    fun findByUsername(username: String): User?
}