package com.example.lesson5.repository;

import com.example.lesson5.model.TppRefProductClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TppRefProductClassRepository extends JpaRepository<TppRefProductClass, String> {

    TppRefProductClass findByValue(String value);
}
