package com.mohsen.demo1.auth.repository

import com.mohsen.demo1.auth.model.Lesson
import com.mohsen.demo1.auth.model.Meeting
import org.springframework.data.jpa.repository.JpaRepository

interface MeetingRepository: JpaRepository<Meeting, Long>{
    fun findByLesson_Id(lessonId: Int): Meeting
}