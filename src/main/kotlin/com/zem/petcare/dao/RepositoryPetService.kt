package com.zem.petcare.dao

import com.zem.petcare.entities.PetLover
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.zem.petcare.entities.PetService


@Repository
interface RepositoryPetService: JpaRepository<PetService, Long> {
    fun findByName(name: String): PetService

}