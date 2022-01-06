package com.mohsen.demo1.auth.validator

import com.mohsen.demo1.auth.model.User
import com.mohsen.demo1.auth.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator


@Component
class UserValidator
    @Autowired constructor(
    private val userService: UserService
): Validator{
    override fun supports(clazz: Class<*>): Boolean =
        User::class.java == clazz

    override fun validate(target: Any, errors: Errors) {
        val user = target as User

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty")
        if (user.username.length < 6 || user.username.length > 32) {
            errors.rejectValue("username", "Size.userForm.username")
        }

        if (userService.findByUserName(user.username) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username")
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty")
        if (user.password.length < 8 || user.password.length > 32) {
            errors.rejectValue("password", "Size.userForm.password")
        }

        if (user.passwordConfirm != user.password) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm")
        }
    }


}