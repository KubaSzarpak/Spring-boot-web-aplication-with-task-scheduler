package com.example.Aplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlanetServiceTests {


    private final PlanetService planetService = new PlanetService();

    @Test
    void getPlanetsTest(){
        Planet p1 = new Planet("Mars");

        Assertions.assertEquals(0, planetService.addPlanet(p1));

        List<Planet> planetList = new ArrayList<>();
        planetList.add(p1);

//        Assertions.assertEquals(planetList, planetService.getPlanets());
    }




}
