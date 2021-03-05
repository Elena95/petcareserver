package com.zem.petcare

import com.zem.petcare.dao.RepositoryPetLover
import com.zem.petcare.entities.PetLover
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
@RequestMapping("petlover")
class PetLoverController {

    @Autowired
    lateinit var repo: RepositoryPetLover

    @PostMapping("/register")
    fun register(@RequestBody petLover: PetLover) : ResponseEntity<Response> {
        val petloverEmail = repo.findByEmail(petLover.email)

        if (petloverEmail?.email != null) {
            return ResponseEntity.badRequest().body(ErrorResponse().apply { msn = "Ya existe" })
        }

        repo.save(petLover)
        return ResponseEntity.ok(GeneralResponse("Registrado correctamente"))
    }
}