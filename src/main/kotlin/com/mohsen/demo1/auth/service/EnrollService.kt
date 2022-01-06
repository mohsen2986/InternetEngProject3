package com.mohsen.demo1.auth.service

import com.mohsen.demo1.auth.model.Enroll
import com.mohsen.demo1.auth.model.Lesson
import com.mohsen.demo1.auth.repository.EnrollRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EnrollService
@Autowired constructor(
    private val enrollRepository: EnrollRepository
){
    fun findAll(): MutableList<Enroll> =
        enrollRepository.findAll()

    fun save(enroll: Enroll) =
        enrollRepository.save(enroll)
}