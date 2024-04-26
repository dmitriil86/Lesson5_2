package com.example.lesson5.repository;

import com.example.lesson5.model.TppRefAccountType;
import com.example.lesson5.model.TppRefProductClass;
import com.example.lesson5.model.TppRefProductRegisterType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TppRefProductRegisterTypeRepository extends JpaRepository<TppRefProductRegisterType, String> {

    List<TppRefProductRegisterType> findByProductClassCodeAndAccountType(TppRefProductClass productClassCode, TppRefAccountType accountType);

    TppRefProductRegisterType findByValue(String value);

}
