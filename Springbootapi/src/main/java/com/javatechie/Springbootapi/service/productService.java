package com.javatechie.Springbootapi.service;


import com.javatechie.Springbootapi.dao.productRepo;
import com.javatechie.Springbootapi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    @Autowired
    private productRepo  repository;

    private static final String TOPIC = "Kafka_Example";

    public Product saveProduct(Product product){
        Product product1 = repository.save(product);
        kafkaTemplate.send(TOPIC, product);
        return product1;
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }
    public Product getProductbyId(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductbyName(String name){
        return repository.findByName(name);
        }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed !! "+id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);

    }


}
