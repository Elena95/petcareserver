package com.zem.petcare

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
//@Controller
class PetcareApplication {

    /*@RequestMapping("/")
    @ResponseBody
    fun home(): String {
        return "Hola mundo"
    }*/

}



fun main(args: Array<String>) {
    runApplication<PetcareApplication>(*args)
}
