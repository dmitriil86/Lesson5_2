package com.example.lesson5.controllers;

import com.example.lesson5.dto.RequestAccountReq;
import com.example.lesson5.dto.ResponseBodyAccountDto;
import com.example.lesson5.interfaces.AccountInterface;
import com.example.lesson5.services.AccountServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class AccountInterfaceImp implements AccountInterface {
    private final AccountServices accountServices;

    @Override
    public ResponseEntity<ResponseBodyAccountDto> createAccount(RequestAccountReq req) {

        ResponseBodyAccountDto response = accountServices.cheсkAccountReq(req);

        return  ResponseEntity.ok(response);
    }
}
