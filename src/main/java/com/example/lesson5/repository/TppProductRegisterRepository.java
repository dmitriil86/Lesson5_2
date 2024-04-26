package com.example.lesson5.repository;

import com.example.lesson5.model.TppProductRegister;
import com.example.lesson5.model.TppRefProductRegisterType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TppProductRegisterRepository extends JpaRepository<TppProductRegister,String> {

    List<TppProductRegister> findByProductIdAndProductRegisterType(Integer productId, TppRefProductRegisterType type);

    List<TppProductRegister> findByProductId(Integer productId);

}
