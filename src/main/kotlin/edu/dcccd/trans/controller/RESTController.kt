package edu.dcccd.trans.controller

import edu.dcccd.trans.service.JokeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RESTController @Autowired
constructor(private val jokeService: JokeService) {
    val joke: String?
        @GetMapping(value = ["/joke"])
        @Throws(Exception::class)
        get() = jokeService.getJoke("Craig", "Walls")
}
