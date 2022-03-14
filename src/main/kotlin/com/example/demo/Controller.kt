package com.example.demo




import com.google.gson.Gson
import org.springframework.web.bind.annotation.*

@RestController
class Controller(private val personasRepository: PersonasRepository) {

    @GetMapping("people")
    fun getpeople():List<People>{
        return personasRepository.findAll()
    }

    @GetMapping("people/{peopleId}")
    fun getpeopleid(@PathVariable peopleId: Int):Any{

        try {
            if(personasRepository.findById(peopleId).isEmpty)
                return "People NOT FOUND"

        }catch (e: Exception){
            return e
        }

        return personasRepository.getById(peopleId)
    }
   //curl --request POST --header "Content-type:application/json" --data "{\"name\":\"Leopoldo\",\"height\":\"34\",\"mass\":\"67\",\"hair_color\":\"white\",\"skin_color\":\"green\",\"eye_color\":\"black\",\"birth_year\":\"24BBY\",\"gender\":\"male\",\"homeworld\":\"https://swapi.dev/api/planets/1/\",\"created\":\"2014-12-10T15:59:50.509000Z\",\"edited\":\"2014-12-20T21:17:50.323000Z\",\"url\":\"https://swapi.dev/api/people/11/\"}" localhost:8083/insertPeople
    @PostMapping("insertPeople")
    fun insertarPeople(@RequestBody datos : People): Any {
        try{
            personasRepository.save(datos)
            println(datos)
        }catch (e: Exception) {
            return e
        }
        return datos
    }
}