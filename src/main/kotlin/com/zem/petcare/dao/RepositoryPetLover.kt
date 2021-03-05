package com.zem.petcare.dao

import com.zem.petcare.entities.PetLover
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepositoryPetLover: JpaRepository<PetLover, Long> {

    fun findByEmail(email: String): PetLover?

}

