package com.example.service;

import com.example.model.GameOfThrones;
import com.example.repository.GameOfThronesRepo;
import com.github.javafaker.Faker;
import io.quarkus.runtime.Startup;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

@Startup
@ApplicationScoped
public class GameOfThronesService {

    private final GameOfThronesRepo repo;
    private final Faker faker;

    public GameOfThronesService(GameOfThronesRepo gameOfThronesRepo) {
        this.repo = gameOfThronesRepo;
        this.faker = Faker.instance();
    }

    @PostConstruct
    void init() {
        repo.count()
                .flatMap(aLong -> {
                            if (aLong == 0) {
                                return Multi.createFrom()
                                        .range(0, 100)
                                        .map(integer -> new GameOfThrones(ObjectId.get(),
                                                faker.gameOfThrones().character(),
                                                faker.gameOfThrones().city(),
                                                faker.gameOfThrones().dragon(),
                                                faker.gameOfThrones().house(),
                                                faker.gameOfThrones().quote()))
                                        .collect()
                                        .asList()
                                        .flatMap(repo::persist);

                            }

                            return Uni.createFrom().voidItem();
                        }

                )
                .await()
                .indefinitely();

    }
}
