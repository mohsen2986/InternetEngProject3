package com.mohsen.demo1.auth.web

import com.mohsen.demo1.auth.model.User
import com.mohsen.demo1.auth.repository.TermConfigurationRepository
import com.mohsen.demo1.auth.service.SecurityService
import com.mohsen.demo1.auth.service.UserService
import com.mohsen.demo1.auth.validator.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.sql.Date
import javax.servlet.http.HttpServletRequest


@Controller
class UserController
@Autowired constructor(
    private val userService: UserService ,
    private val securityService: SecurityService ,
    private val userValidator: UserValidator ,
    private val termConfigurationRepository: TermConfigurationRepository
){

    @GetMapping("/registration")
    fun registration(model: Model): String {
        model.addAttribute("userForm", User())
        return "registration"
    }

    @PostMapping("/registration")
    fun registration(@ModelAttribute("userForm") userForm: User, bindingResult: BindingResult): String {
        userValidator!!.validate(userForm, bindingResult)
        if (bindingResult.hasErrors()) {
            return "registration"
        }
        userService!!.save(userForm)
        securityService!!.autoLogin(userForm.username, userForm.passwordConfirm)
        return "redirect:/welcome"
    }

    @GetMapping("/login")
    fun login(model: Model, error: String?, logout: String?): String {
        if (error != null) model.addAttribute("error", "Your username and password is invalid.")
        if (logout != null) model.addAttribute("message", "You have been logged out successfully.")
        return "login"
    }

    @GetMapping(*["/", "/welcome"])
    fun welcome(model: Model?): String {
        return "welcome"
    }

    @GetMapping("/test")
    fun test(request: HttpServletRequest){
        val date: Date = Date(System.currentTimeMillis())
       println(termConfigurationRepository.findAll().get(0).unitSelectionInterval)
        println(date.after(termConfigurationRepository.findAll().get(0).unitSelectionInterval))
    }
}