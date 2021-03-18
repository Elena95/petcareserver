package com.zem.petcare

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class SiteController {

    @GetMapping("/hello")
    fun hello(@RequestParam("name", required = false, defaultValue = "World") name: String ,model: Model): String {
        model.addAttribute("name", name)
        return "hello"
    }
}