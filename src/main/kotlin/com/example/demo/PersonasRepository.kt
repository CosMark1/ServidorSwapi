package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository


interface PersonasRepository : JpaRepository<People, Int>