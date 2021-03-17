package com.zem.petcare

import com.zem.petcare.dao.RepositoryPetLover
import com.zem.petcare.entities.PetLover
import com.zem.petcare.entities.PetService
import com.zem.petcare.model.AuthenticationModel
import com.zem.petcare.responses.ErrorResponse
import com.zem.petcare.responses.GeneralResponse
import com.zem.petcare.responses.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.full.memberProperties

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

    @PostMapping("/authentication")
    fun authentication(@RequestBody authenticationRequest: AuthenticationModel): ResponseEntity<Response>{
        AuthenticationModel::class.memberProperties.forEach{
            if (it.get(authenticationRequest)==null){
                return ResponseEntity.badRequest().body(ErrorResponse().apply { msn = "${it.name}no proporcionado"})
            }
        }
        val petLover = repo.findByEmail(authenticationRequest.email!!)
        val password = authenticationRequest.password

        return if(password == petLover.password){
            ResponseEntity.ok(GeneralResponse("Datos correctos").apply { msn = "Peticion correcta"})
        }else{
            ResponseEntity.badRequest().body(ErrorResponse().apply{msn = "Usuario o contraseña incorrectos"})
        }
    }

    @PostMapping("/registerService")
    fun register(@RequestBody petService: PetService): ResponseEntity<Response> {
        /* val nameService = repo.findByName(petService.name)
        if (nameService.name != null){
            return ResponseEntity.badRequest().body(ErrorResponse().apply {msn = "Ya existe"})
        }
        repo.save(petService)
        return ResponseEntity.ok(GeneralResponse("Registrado"))
    }*/
        return ResponseEntity.ok(GeneralResponse("Registrado"))

    }
}