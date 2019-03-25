package com.standard.app.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    fun Hello() : String {
        return "hello world"
    }
}