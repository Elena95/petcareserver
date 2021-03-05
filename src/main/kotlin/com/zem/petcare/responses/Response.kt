package com.zem.petcare.responses

import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(value = ["status", "msn"])
open class Response {
    var status: Int = 1
    var msn: String? = ""
}
