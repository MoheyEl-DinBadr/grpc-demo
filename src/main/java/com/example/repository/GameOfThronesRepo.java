package com.example.repository;

import com.example.model.GameOfThrones;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameOfThronesRepo implements ReactivePanacheMongoRepository<GameOfThrones> {
}
