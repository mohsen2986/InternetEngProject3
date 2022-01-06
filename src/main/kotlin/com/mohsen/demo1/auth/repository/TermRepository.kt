package com.mohsen.demo1.auth.repository

import com.mohsen.demo1.auth.model.Term
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TermRepository: JpaRepository<Term, Long>{}