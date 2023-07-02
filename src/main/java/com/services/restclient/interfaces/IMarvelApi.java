package com.services.restclient.interfaces;

import com.services.restclient.model.Result;
import com.services.restclient.model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class IMarvelApi implements MarvelApi {

    private static final String ENDPOINT = "http://gateway.marvel.com/v1/public/";
    private static final String API_KEY = "69e6349b0dbba978c331bc0cf63bca17";
    private static final String HASH = "ea5b9d1d0fab181f5a7d15d00f9717c9";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Result> getCharacters() {
        var map = Map.of("ts","1","apikey",IMarvelApi.API_KEY,"hash",IMarvelApi.HASH);
        var response = restTemplate.getForEntity(IMarvelApi.ENDPOINT.concat("characters?ts={ts}&apikey={apikey}&hash={hash}"), Root.class, map);
        return Objects.requireNonNull(response.getBody()).getData().getResults();
    }

    @Override
    public Result getCharacterById(String id) {
        var map = Map.of("ts","1","apikey",IMarvelApi.API_KEY,"hash",IMarvelApi.HASH);
        var response = restTemplate.getForEntity(IMarvelApi.ENDPOINT.concat("characters/").concat(id).concat("?ts={ts}&apikey={apikey}&hash={hash}"), Root.class, map);
        return Objects.requireNonNull(response.getBody()).getData().getResults().stream().findFirst().orElse(null);
    }
}
