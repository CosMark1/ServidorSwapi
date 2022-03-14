package com.example.demo

import com.google.gson.Gson
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id



data class Resultado(val results: List<People>) {
    override fun toString():String{
        val gson= Gson()
        return gson.toJson(this)
    }
}