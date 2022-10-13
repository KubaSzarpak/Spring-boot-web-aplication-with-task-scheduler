package com.example.Aplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet implements Comparable<Planet>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    public Planet (String name){
        this.name = name;
    }

    public Planet() {
        this.name = null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Planet p) {
        if(this.name.toUpperCase().charAt(0) > p.getName().toUpperCase().charAt(0))
            return 1;
        if(this.name.toUpperCase().charAt(0) < p.getName().toUpperCase().charAt(0))
            return -1;
        return 0;
    }

}
