package com.testeapi.LojaFerramentasApi.api;


import com.testeapi.LojaFerramentasApi.model.Product;
import com.testeapi.LojaFerramentasApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/ferramentas")
@RestController
public class ApiController {
    private ProductService productService;

    @Autowired
    public ApiController(ProductService productService){
        this.productService = productService;
    }

    //The api adds a products here
    @PostMapping
    public  void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    //returns all products here
    @GetMapping
    public List<Product> getAllPeople(){
        return productService.getAllPeople();
    }

    //A api searches for a product by id
    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable("id")UUID id){
        return productService.getProductById(id)
                .orElse(null);
    }
    //the API searches for a product by ID and deletes the product
     @DeleteMapping(path="{id}")
    public void deleteProductById(@PathVariable("id") UUID id){
        productService.deleteProduct(id);
    }
    @PutMapping(path = "{id}")
    public void updateProduct(@PathVariable("id") UUID id,@RequestBody Product productToUpdate){
        productService.updateProduct(id,productToUpdate);
    }
}
