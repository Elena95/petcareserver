package com.zem.petcare.entities
import javax.persistence.*

@Entity(name = "petlovers")
data class PetLover (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @Column(nullable = false)
    var name: String,

    @Column (nullable = false)
    var email: String,

    @Column(nullable = false)
    var password: String
        )