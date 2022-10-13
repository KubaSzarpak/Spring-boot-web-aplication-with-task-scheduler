package com.example.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PlanetService {

    @Autowired
    public PlanetsRepository planetsRepository;

    public List<Planet> getPlanets() {
        return planetsRepository.findAll();
    }

    public Planet getByName(String name) {
        for (Planet planet : planetsRepository.findAll()) {
            if (planet.getName().equals(name)) {
                return planet;
            }
        }
        return null;
    }

    public int addPlanet(Planet planet) {
        for(Planet p : planetsRepository.findAll()){
            if(planet.getName().equals(p.getName())){
                return 1;
            }
        }
        planetsRepository.save(planet);
        return 0;
    }

    public List<Planet> getSorted(String pattern, String order){

        if(!(order.equals("ASC") || order.equals("DESC"))) {
            System.out.println("Error");
            return null;
        } //checks if order is correct

        List<Planet> planets = new ArrayList<>();

        Pattern p = Pattern.compile(".*" + pattern + ".*");
        Matcher m;

        for(Planet planet : planetsRepository.findAll()){
            m = p.matcher(planet.getName());
            if(m.matches()){
                planets.add(planet);
            }
        } //add planets which matches the pattern to the list "planets"

        if(order.equals("ASC")) {
            Collections.sort(planets);
        } else {
            Collections.sort(planets, Collections.reverseOrder());
        } //sort the list "planets"

        return planets;
    }
}
