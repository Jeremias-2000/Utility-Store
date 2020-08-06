package com.testeapi.LojaFerramentasApi.controller;

import com.testeapi.LojaFerramentasApi.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductsCommands {
    int insertProduct(UUID id, Product product);

    default int insertProduct(Product product){
        UUID id = UUID.randomUUID();
        return insertProduct(id,product);
    }
    List<Product> selectAllPeople();
    Optional<Product> selectProductById(UUID id);

    int deleteProductById(UUID id);
    int updateById(UUID id,Product product);
}
