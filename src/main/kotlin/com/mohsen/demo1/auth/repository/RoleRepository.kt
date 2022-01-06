package com.mohsen.demo1.auth.repository

import com.mohsen.demo1.auth.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long> {

}