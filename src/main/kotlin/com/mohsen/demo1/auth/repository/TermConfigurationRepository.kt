package com.mohsen.demo1.auth.repository

import com.mohsen.demo1.auth.model.TermConfiguration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TermConfigurationRepository: JpaRepository<TermConfiguration, Long>