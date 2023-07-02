package com.services.restclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Result{
    private int id;
    private String name;
    private String description;
    private Date modified;
    private Thumbnail thumbnail;
    private String resourceURI;
    private Comics comics;
    private Series series;
    private Stories stories;
    private Events events;
    private List<Url> urls;
}
