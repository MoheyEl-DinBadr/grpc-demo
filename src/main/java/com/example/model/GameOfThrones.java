package com.example.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@MongoEntity(collection="GameOfThrones")
public record GameOfThrones(@BsonId ObjectId id, String character, String city, String dragon, String house, String quote) {

}
