package com.example.lesson5.services;

import com.example.lesson5.dto.RequestAccountReq;
import com.example.lesson5.dto.ResponseBodyAccountDto;

public interface AccountServices {

    ResponseBodyAccountDto cheсkAccountReq(RequestAccountReq accountReq);

}
