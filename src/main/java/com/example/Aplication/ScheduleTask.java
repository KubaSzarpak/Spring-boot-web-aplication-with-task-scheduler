package com.example.Aplication;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ScheduleTask {

    @Autowired
    PlanetService planetService;

    @Scheduled(fixedRate = 1000*60*60)
    public void readJSON() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://swapi.dev/api/planets/")).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(response.body());

        JSONArray results = jsonObject.getJSONArray("results");


        for(int i = 0; i < results.length(); i++) {
            planetService.addPlanet(new Planet(results.getJSONObject(i).getString("name")));
        }

    }
}
