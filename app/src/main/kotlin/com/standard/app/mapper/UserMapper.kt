package com.standard.app.mapper

import com.standard.app.entity.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select

interface UserMapper {

    @Select("SELECT * FROM USER")
    fun selectAll(): List<User>

    @Insert("INSERT INTO USER (name, age, job) VALUES (#{name}, #{age}, #{job})")
    fun insert(user: User)
}