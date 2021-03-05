package com.zem.petcare.responses

data class ErrorResponse (

    val errors: List<String>? = emptyList()
        ): Response(){
            init{
                status = 2
            }
        }
