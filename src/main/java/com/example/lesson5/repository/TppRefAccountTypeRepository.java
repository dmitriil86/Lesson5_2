package com.example.lesson5.repository;

import com.example.lesson5.model.TppRefAccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TppRefAccountTypeRepository extends JpaRepository<TppRefAccountType, String> {

    TppRefAccountType findByValue(String value);
}
