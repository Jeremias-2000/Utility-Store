package com.testeapi.LojaFerramentasApi.service;

import com.testeapi.LojaFerramentasApi.controller.ProductsCommands;
import com.testeapi.LojaFerramentasApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductsCommands productsCommands;

    @Autowired
    public ProductService(ProductsCommands productsCommands)
    {
        this.productsCommands = productsCommands;
    }

    public int addProduct(Product product){
        return productsCommands.insertProduct(product);
    }

    public List<Product> getAllPeople(){
        return productsCommands.selectAllPeople();
    }

    public Optional<Product> getProductById(UUID id){
        return productsCommands.selectProductById(id);
    }
    public int deleteProduct(UUID id){
        return productsCommands.deleteProductById(id);
    }
    public int updateProduct(UUID id,Product newProduct){
        return productsCommands.updateById(id,newProduct);
    }
}
