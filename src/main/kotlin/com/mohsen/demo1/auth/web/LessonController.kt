package com.mohsen.demo1.auth.web

import com.mohsen.demo1.auth.model.*
import com.mohsen.demo1.auth.repository.EnrollRepository
import com.mohsen.demo1.auth.repository.TermConfigurationRepository
import com.mohsen.demo1.auth.repository.UserRepository
import com.mohsen.demo1.auth.service.EnrollService
import com.mohsen.demo1.auth.service.LessonService
import com.mohsen.demo1.auth.service.MeetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import java.util.*
import javax.servlet.http.HttpServletRequest

@Controller
class LessonController
    @Autowired constructor(
        private val lessonService: LessonService ,
        private val meetingService: MeetingService ,
        private val userRepository: UserRepository ,
        private val enrollRepository: EnrollService ,
        private val termConfigurationRepository: TermConfigurationRepository
    ){
        @RequestMapping("/lesson")
        fun showAllLessonsPage(model: Model): String {
            model.addAttribute("lessons" , lessonService.allLessons())
            return "all-lessons"
        }

    @RequestMapping("/create-lesson" , method = [RequestMethod.GET])
        fun showCreateLesson(model: ModelMap): String{
            model.addAttribute("lesson" , Lesson())
            model.addAttribute("users" , userRepository.findAll())
            return "create-lesson"
        }

    @RequestMapping("/create-lesson", method = [RequestMethod.POST])
    fun createLesson(
        @ModelAttribute("lesson")lesson: Lesson ,
        @RequestParam("sunday") sunday: String? ,
        @RequestParam("monday") monday: String? ,
        @RequestParam("tuesday") tuesday: String? ,
        @RequestParam("wednesday") wednesday: String? ,
        @RequestParam("thursday") thursday: String? ,
        @RequestParam("friday") friday: String? ,
        @RequestParam("saturday") saturday: String? ,
        @RequestParam("selected_user") selectedUser: String
    ): String{
        val user = userRepository.findByUsername(selectedUser)
        println("!!!! $user")
        lesson.user = user!!

        lessonService.saveLesson(lesson)
        sunday?.let {
            meetingService.saveMeeting(Meeting(id = 0 , lesson = lesson , day = 0 ,))
        }
        monday?.let {
            meetingService.saveMeeting(Meeting(id = 0 , lesson = lesson , day = 1))
        }
        tuesday?.let {
            meetingService.saveMeeting(Meeting(id = 0 , lesson = lesson , day = 2))
        }
        wednesday?.let {
            meetingService.saveMeeting(Meeting(id = 0 , lesson = lesson , day = 3))
        }
        thursday?.let {
            meetingService.saveMeeting(Meeting(id = 0 , lesson = lesson , day = 4))
        }
        friday?.let {
            meetingService.saveMeeting(Meeting(id = 0 , lesson = lesson , day = 5))
        }
        saturday?.let {
            meetingService.saveMeeting(Meeting(id = 0 , lesson = lesson , day = 6))
        }
        return "redirect:/create-lesson"
    }

    @RequestMapping("/select-lessons" , method = [RequestMethod.GET])
    fun showSelectLesson(
        model: Model ,
        request: HttpServletRequest
    ): String{
        // GET CURRENT USER
        val user = userRepository.findByUsername(request.userPrincipal.name)!!

        model.addAttribute("lessons" ,lessonService.allLessons())

        val enroll = enrollRepository.findAll().filter { it.user.id == user.id }.map { it-> it.lesson.id }
        val lessons = lessonService.allLessons().filter { it.id in  enroll}

        model.addAttribute("selected_lessons" ,lessons)
        model.addAttribute("lesson_id" ,"0")
        println("THE CURRENT USER IS: ${user} ")


        return "select-lessons"
    }

    @RequestMapping("/add-select-lessons" , method = [RequestMethod.POST])
    fun selectLesson(
        @ModelAttribute("lesson_id") LessonId: String ,
        request: HttpServletRequest
    ):String {
//
        val start = termConfigurationRepository.findAll().last().unitSelectionInterval
        val end = termConfigurationRepository.findAll().last().unitSelectionIntervalEnd
        val today :Date = Date(System.currentTimeMillis())
        if (today.after(start))
            return "redirect:/select-lessons"

        // GET CURRENT USER
        val user = userRepository.findByUsername(request.userPrincipal.name)
        println("the seleced_lesson id : $LessonId")

        val lesson = lessonService.findById(LessonId)

        val enroll = Enroll(0 , 0 , user!! ,lesson!!)

        enrollRepository.save(enroll)



        return "redirect:/select-lessons"
    }

    @RequestMapping("/program")
    fun showProgram(model: Model , request: HttpServletRequest): String{
        val start = termConfigurationRepository.findAll().last().unitSelectionInterval
        val end = termConfigurationRepository.findAll().last().unitSelectionIntervalEnd
        val today :Date = Date(System.currentTimeMillis())
        if(today.after(end) || start.after(today)){
            val meetings = mutableListOf<MeetObj>()
            model.addAttribute("meetings" , meetings)
            return "program"
        }

        val user = userRepository.findByUsername(request.userPrincipal.name)!!


        val enrolls: List<Enroll> = enrollRepository.findAll().filter { it.user.id == user.id }

        val meetings = mutableListOf<MeetObj>()
        if(request.isUserInRole("OSTAD")){
            val t = lessonService.allLessons().filter { it.user.id == user.id }
            println(t)
            t.forEach {
                it?.let {
                    val meeting = meetingService.findByLesson(it.id)
                    meetings.add(MeetObj(calculateDay(meeting.day), meeting.time, it.name))
                }
            }
        }
        else{
            enrolls.forEach {
                val meeting = meetingService.findByLesson(it.lesson.id)
                meetings.add(MeetObj(calculateDay(meeting.day), meeting.time, it.lesson.name))
            }
        }

        model.addAttribute("meetings" , meetings)

        return "program"
    }

    @RequestMapping("/mark")
    fun showMarks(model: Model): String{
        val user = userRepository.findByUsername("mohsen_alak")!!
        val lessons:List<Lesson> = lessonService.allLessons().filter { it.user.id == user.id }
        val enrolls = enrollRepository.findAll()

        val last = enrolls.filter { it.lesson.id in lessons.map { it -> it.id } }

        println("$last")
        model.addAttribute("enrolls" , last)
        model.addAttribute("mark" , Mark(0.toString(), 0.toString()))

        return "mark"
    }

    @RequestMapping("/mark" , method = [RequestMethod.POST])
    fun saveMark(
        @RequestParam("id")id: String ,
        @RequestParam("mark") mark: String
    ): String{
        println("$id | $mark")
        val start = termConfigurationRepository.findAll().last().unitSelectionInterval
        val end = termConfigurationRepository.findAll().last().unitSelectionIntervalEnd
        val today :Date = Date(System.currentTimeMillis())
        if(!(today.after(end))){
            return "redirect:/mark"
        }
        val entorll: Enroll = enrollRepository.findAll().filter { it.id.toString() == id }[0]

        entorll.mark = mark.toInt()

        enrollRepository.save(entorll)

        return "redirect:/mark"
    }

    fun calculateDay(day: Int): String =
        when(day){
            0 -> "Sunday"
            1 -> "Monday"
            2 -> "Tuesday"
            3 -> "Wednesday"
            4 -> "Thursday"
            5 -> "Friday"
            6 -> "SATURDAY"
            else -> ""
        }

}