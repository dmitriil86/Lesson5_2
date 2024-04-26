package com.example.lesson5.repository;

import com.example.lesson5.model.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

    Agreement findByNumber(String number);
}
