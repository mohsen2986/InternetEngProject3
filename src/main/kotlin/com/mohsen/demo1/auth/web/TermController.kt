package com.mohsen.demo1.auth.web

import com.mohsen.demo1.auth.model.Term
import com.mohsen.demo1.auth.model.TermConfiguration
import com.mohsen.demo1.auth.service.TermService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class TermController
    @Autowired constructor(
        private val termService: TermService
    ){
        @RequestMapping("/term")
        fun showTerm(model: Model): String{
            model.addAttribute("term" , Term())
            model.addAttribute("termConfiguration" , TermConfiguration())

            return "term"
        }

    @RequestMapping("/term" , method = [RequestMethod.POST])
    fun createTerm(
        @ModelAttribute("term") term: Term ,
        @ModelAttribute("termConfiguration") termConfiguration: TermConfiguration
    ): String{
        termService.saveLessonAndConfigurations(term = term , termConfiguration = termConfiguration)
        return "redirect:/term"
    }
}