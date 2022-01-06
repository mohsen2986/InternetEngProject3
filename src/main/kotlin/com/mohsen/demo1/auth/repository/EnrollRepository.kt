package com.mohsen.demo1.auth.repository

import com.mohsen.demo1.auth.model.Enroll
import org.springframework.data.jpa.repository.JpaRepository

interface EnrollRepository: JpaRepository<Enroll, Long>