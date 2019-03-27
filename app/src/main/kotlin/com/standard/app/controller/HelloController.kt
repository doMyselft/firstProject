package com.standard.app.controller

import com.standard.app.entity.User
import com.standard.app.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Autowired
    lateinit var userMapper: UserMapper

    @ResponseBody
    @RequestMapping("/hello")
    fun hello() : String {
        return "hello world"
    }

    @RequestMapping("/insertUser")
    fun insertUser() {
        val user = User("test")
        user.age = 3
        user.job = "developer"
        userMapper.insert(user)
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    fun selectAll(): List<User> {
        return userMapper.selectAll()
    }
}