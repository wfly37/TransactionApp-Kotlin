package edu.dcccd.trans.service

import edu.dcccd.trans.entity.JokeResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class JokeService @Autowired constructor(restTemplate: RestTemplateBuilder) {
    private val restTemplate: RestTemplate

    init {
        this.restTemplate = restTemplate.build()
    }

    fun getJoke(first: String, last: String): String? {
        val url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last)
        return restTemplate.getForObject(url, JokeResponse::class.java)!!.value.joke
    }

    companion object {
        private val BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]"
    }
}
