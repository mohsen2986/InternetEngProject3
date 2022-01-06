package com.mohsen.demo1.auth.repository

import com.mohsen.demo1.auth.model.Lesson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LessonRepository: JpaRepository<Lesson , Long>{
    fun findById(id: Int): Lesson?
}