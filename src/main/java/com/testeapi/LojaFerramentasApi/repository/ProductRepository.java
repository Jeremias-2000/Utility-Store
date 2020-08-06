package com.testeapi.LojaFerramentasApi.repository;


import com.testeapi.LojaFerramentasApi.controller.ProductsCommands;
import com.testeapi.LojaFerramentasApi.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("test")
public class ProductRepository implements ProductsCommands {
    private static List<Product> DB = new ArrayList<>();

    @Override
    public int insertProduct(UUID id, Product product) {
        DB.add(new Product(id, product.getDescription(), product.getPrice()));
        return 1;
    }

    @Override
    public List<Product> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Product> selectProductById(UUID id) {
        return DB.stream().filter(product -> product.getId()
                .equals(id)).findFirst();
    }

    @Override
    public int deleteProductById(UUID id) {
        Optional<Product> ProductTest = selectProductById(id);
        if(!ProductTest.isPresent()){
            throw new RuntimeException("Object not found");
        }
        DB.remove(ProductTest.get());
        return 1;
    }

    @Override
    public int updateById(UUID id, Product update) {
        return selectProductById(id).map(product -> {
            int indexOfProductToUpdate = DB.indexOf(product);
            if(indexOfProductToUpdate >= 0) {
                DB.set(indexOfProductToUpdate, new Product(id, update.getDescription()
                        , update.getPrice()));
            return 1;
            }else{
                return 0;
            }
        }).orElse(0);
    }
}
