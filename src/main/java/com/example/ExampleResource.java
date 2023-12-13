package com.example;

//import com.example.model.TestPojoTest;

import com.example.model.GameOfThrones;
import com.example.repository.GameOfThronesRepo;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/hello")
public class ExampleResource {

    private final GameOfThronesRepo repo;

    public ExampleResource(GameOfThronesRepo repo) {
        this.repo = repo;
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Uni<TestPojoTest> hello() {
//        return repo.streamAll()
//                .collect()
//                .asList()
//                .map(TestPojoTest::new);
//    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<GameOfThrones>> hello() {
        return repo.streamAll()
                .collect()
                .asList();
    }


}
