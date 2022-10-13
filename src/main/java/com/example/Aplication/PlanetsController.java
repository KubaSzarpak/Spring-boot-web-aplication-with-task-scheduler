package com.example.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetsController {

    @Autowired
    PlanetService planetService;

    @GetMapping("/planets")
    public List<Planet> getAll(){
        return planetService.getPlanets();
    }

    @GetMapping("/planets/{name}")
    public Planet getById(@PathVariable("name") String name){
        return planetService.getByName(name);
    }

    @PostMapping("/planets")
    public int savePlanet(@RequestBody Planet planet){
        return planetService.addPlanet(planet);
    }

    @GetMapping("/planets/")
    @ResponseBody
    public List<Planet> getSorted(@RequestParam String filter, @RequestParam String order){
        return planetService.getSorted(filter, order);
    }

}
