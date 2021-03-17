package com.zem.petcare

import com.zem.petcare.dao.RepositoryPetLover
import com.zem.petcare.dao.RepositoryPetService
import com.zem.petcare.entities.PetLover
import com.zem.petcare.entities.PetService
import com.zem.petcare.responses.ErrorResponse
import com.zem.petcare.responses.GeneralResponse
import com.zem.petcare.responses.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController

@RequestMapping("petservice")
class PetServiceController {
    @Autowired
    lateinit var repo: RepositoryPetService

    @PostMapping("/registerService")
    fun register(@RequestBody petService: PetService): ResponseEntity<Response> {
        val nameService = repo.findByName(petService.name)
        if (nameService.name != null){
            return ResponseEntity.badRequest().body(ErrorResponse().apply {msn = "Ya existe"})
        }
        repo.save(petService)
        return ResponseEntity.ok(GeneralResponse("Registrado"))
    }
}