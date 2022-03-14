package com.example.demo

import com.google.gson.Gson

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ElementCollection


@Entity
data class People(
    val name: String,
    val height: String,
    val mass: String,
    val hair_color: String,
    val skin_color: String,
    val eye_color: String,
    val birth_year: String,
    val gender: String,
    val homeworld: String,
    @ElementCollection
    val films: List<String>,
    @ElementCollection
    val species: List<String>,
    @ElementCollection
    val vehicles: List<String>,
    @ElementCollection
    val starships: List<String>,
    val created: String,
    val edited: String,
    val url: String
){
    @Id
    @GeneratedValue
    var id = 0
    override fun toString() : String{
        val gson = Gson()
        return gson.toJson(this)
    }
}