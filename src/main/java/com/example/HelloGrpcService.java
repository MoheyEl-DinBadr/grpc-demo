/*
package com.example;

import com.example.repository.GameOfThronesRepo;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

    private final GameOfThronesRepo repo;

    public HelloGrpcService(GameOfThronesRepo repo) {
        this.repo = repo;
    }

    @Override
    public Uni<TestPojo> sayHello(Empty emptyRequest) {
        return repo.streamAll()
                .map(gameOfThrones -> GameOfThronesGrpc.newBuilder()
                        .setId(gameOfThrones.id().toString())
                        .setCity(gameOfThrones.city())
                        .setCharacter(gameOfThrones.character())
                        .setDragon(gameOfThrones.dragon())
                        .setHouse(gameOfThrones.house())
                        .setQuote(gameOfThrones.quote())
                        .build())
                .collect()
                .asList()
                .map(it -> TestPojo.newBuilder()
                        .addAllGameOfThronesList(it)
                        .build());
    }

}
*/
