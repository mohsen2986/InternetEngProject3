package com.mohsen.demo1.auth.service

import com.mohsen.demo1.auth.model.Lesson
import com.mohsen.demo1.auth.model.Meeting
import com.mohsen.demo1.auth.repository.MeetingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MeetingService
@Autowired constructor(
    private val meetingRepository: MeetingRepository
){
    fun saveMeeting(meeting: Meeting) =
        meetingRepository.save(meeting)

    fun findByLesson(lesson: Int) =
        meetingRepository.findByLesson_Id(lesson)
}