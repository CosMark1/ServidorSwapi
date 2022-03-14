package com.example.demo

import com.google.gson.Gson
import okhttp3.*
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.IOException


@Configuration
class Database {
    @Bean
    fun initDatabase(personasRepository: PersonasRepository): CommandLineRunner {
        return CommandLineRunner {
            println("Base de datos creandose")

            val client = OkHttpClient()

            val request = Request.Builder()

            request.url("https://swapi.dev/api/people/")
            val call = client.newCall(request.build())
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    println(e.toString())


                }

                override fun onResponse(call: Call, response: Response) {
                    println(response.toString())
                    response.body?.let { responseBody ->
                        val body = responseBody.string()
                        println(body)
                        val gson = Gson()
                        val people = gson.fromJson(body, Resultado::class.java)

                            people.results.forEach {
                                println(it)
                                personasRepository.save(it)

                            }


                    }
                }
            })

            println("Base de datos creada y llena de datos")
        }
    }
}