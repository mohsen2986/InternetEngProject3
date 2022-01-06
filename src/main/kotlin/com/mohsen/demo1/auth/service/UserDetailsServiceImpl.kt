package com.mohsen.demo1.auth.service

import com.mohsen.demo1.auth.model.Role
import com.mohsen.demo1.auth.model.User
import com.mohsen.demo1.auth.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.User as SpringUser

@Service
class UserDetailsServiceImpl(
    @Autowired
    val userRepository: UserRepository
): UserDetailsService{

    override fun loadUserByUsername(username: String?): UserDetails {
        var user: User? = userRepository.findByUsername(username = username!!)

        if(user === null)
            throw UsernameNotFoundException(username)

        val generatedAuthorities: MutableSet<GrantedAuthority> = HashSet()
        user.roles.forEach { role: Role ->
            generatedAuthorities.add(SimpleGrantedAuthority("ROLE_" + role.name))
//            generatedAuthorities.add(SimpleGrantedAuthority("ADMIN"))
        }

        println("!! ${user.roles}")



        return SpringUser(user.username , user.password , generatedAuthorities)
    }


}