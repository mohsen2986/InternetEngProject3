package com.mohsen.demo1.auth.service

import com.mohsen.demo1.auth.model.Term
import com.mohsen.demo1.auth.model.TermConfiguration
import com.mohsen.demo1.auth.repository.TermConfigurationRepository
import com.mohsen.demo1.auth.repository.TermRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TermService
@Autowired constructor(
    private val termRepository: TermRepository,
    private val termConfigurationRepository: TermConfigurationRepository
){
    fun saveLessonAndConfigurations(term: Term , termConfiguration: TermConfiguration){
        termRepository.save(term)
        termConfiguration.term = term
        termConfigurationRepository.save(termConfiguration)
    }
}