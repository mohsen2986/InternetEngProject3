package com.mohsen.demo1.auth.service

interface SecurityService{
    fun findLoggedUserName()

    fun autoLogin(userName: String , password: String)
}