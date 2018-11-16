package edu.dcccd.trans.service;

import edu.dcccd.trans.entity.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service public class JokeService {
    private RestTemplate restTemplate;
    private final static String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

    @Autowired public JokeService( RestTemplateBuilder restTemplate ) {
        this.restTemplate = restTemplate.build();
    }

    public String getJoke(String first, String last) {
        String url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last);
        return restTemplate.getForObject(url, JokeResponse.class).getValue().getJoke();
    }
}
