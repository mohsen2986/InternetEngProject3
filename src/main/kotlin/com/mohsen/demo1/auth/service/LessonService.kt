package com.mohsen.demo1.auth.service

import com.mohsen.demo1.auth.model.Lesson
import com.mohsen.demo1.auth.repository.LessonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LessonService
@Autowired constructor(
    private val lessonRepository: LessonRepository
        ){
    fun allLessons(): MutableList<Lesson> =
         lessonRepository.findAll()


    fun saveLesson(lesson: Lesson): Lesson =
         lessonRepository.save(lesson)

    fun findById(id: String) =
        lessonRepository.findById(id.toInt())

}