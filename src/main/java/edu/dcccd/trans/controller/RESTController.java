package edu.dcccd.trans.controller;

import edu.dcccd.trans.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
    private final JokeService jokeService;

    @Autowired
    public RESTController( JokeService jokeService ) {
        this.jokeService = jokeService;
    }

    @GetMapping(value = ("/joke"))
    public String getJoke() throws Exception {
        return jokeService.getJoke("Craig", "Walls");
    }
}
