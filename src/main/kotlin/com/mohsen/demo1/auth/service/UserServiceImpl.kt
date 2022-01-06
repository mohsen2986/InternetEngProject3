package com.mohsen.demo1.auth.service

import com.mohsen.demo1.auth.model.User
import com.mohsen.demo1.auth.repository.RoleRepository
import com.mohsen.demo1.auth.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl
    @Autowired constructor(
        private val userRepository: UserRepository,
        private val roleRepository: RoleRepository,
        private val bCryptPasswordEncoder: BCryptPasswordEncoder
    ): UserService{
    override fun save(user: User) {
        user.apply {
            password = bCryptPasswordEncoder.encode(user.password)
            roles = HashSet(roleRepository.findAll())
        }
        userRepository.save(user)
    }

    override fun findByUserName(username: String): User? =
        userRepository.findByUsername(username)

}