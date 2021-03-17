package com.zem.petcare.entities

import javax.persistence.*

@Entity(name = "petservices")

data class PetService(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column (nullable = false)
    var name: String,

    @Column(nullable = false)
    var descrip: String,

    @Column(nullable = false)
    var schedule: String,

    @Column(nullable = false)
    var address: String,

    @Column(nullable = false)
    var location:String

)