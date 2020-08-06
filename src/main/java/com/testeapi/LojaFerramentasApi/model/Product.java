package com.testeapi.LojaFerramentasApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {
    private final UUID id;
    private final String description;
    private final double price;

    public Product(@JsonProperty("id") UUID id
            ,@JsonProperty("description") String description
            ,@JsonProperty("price") double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
