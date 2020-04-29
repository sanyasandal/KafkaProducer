package com.javatechie.Springbootapi.dao;

import com.javatechie.Springbootapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface productRepo extends JpaRepository<Product,Integer> {

    @Query("SELECT t FROM Product t WHERE t.name = ?1")
    Product findByName(String name);



}
