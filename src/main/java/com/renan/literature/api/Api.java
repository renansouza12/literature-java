package com.renan.literature.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Api {
    
    public String getApiResults(String address) throws IOException, InterruptedException{
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
         .uri(URI.create(address))
         .build();
         HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); 
         var result = response.body();
         return  result;
    }    
}
