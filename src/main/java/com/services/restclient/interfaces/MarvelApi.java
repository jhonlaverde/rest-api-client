package com.services.restclient.interfaces;

import com.services.restclient.model.Result;

import java.util.List;

public interface MarvelApi {
    public List<Result> getCharacters();
    public Result getCharacterById(String id);
}
