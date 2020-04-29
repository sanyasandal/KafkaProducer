package com.javatechie.Springbootapi.controller;


import com.javatechie.Springbootapi.entity.Product;
import com.javatechie.Springbootapi.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {
    @Autowired
   private productService service;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }
    @GetMapping("/product/{id}")
    public Product findProductbtId(@PathVariable int id){
        return service.getProductbyId(id);
    }
    @GetMapping("/product")
    public Product findProductbyName(@RequestParam String name){
        return service.getProductbyName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("/DeleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return "Product deleted with id : "+id;
    }






}


