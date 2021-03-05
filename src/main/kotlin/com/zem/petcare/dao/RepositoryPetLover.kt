package com.zem.petcare.dao

import com.zem.petcare.model.PetLoverModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RequestBody

@Repository
interface RepositoryPetLover: JpaRepository<PetLoverModel, Long> {

}

