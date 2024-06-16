package com.renan.literature.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBooks(
  @JsonAlias("title")  String title, 

  @JsonAlias("authors") List<DataBooks>  authors, 
  @JsonAlias("name") String name,  
  @JsonAlias("birth_year") String birthYear,  
  @JsonAlias("death_year") String  deathYear,  
  
  @JsonAlias("languages")  List<String> languages,
  @JsonAlias("download_count") double downloads,
  @JsonProperty("results") List<DataBooks> results ) {}
