package com.example.Aplication;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetsRepository extends JpaRepository<Planet, Integer> {}
