package com.example.lesson5.repository;

import com.example.lesson5.model.TppProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TppProductRepository extends JpaRepository<TppProduct, Integer> {

    TppProduct findByNumber(String number);
}
