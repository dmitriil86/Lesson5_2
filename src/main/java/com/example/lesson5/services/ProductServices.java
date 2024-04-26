package com.example.lesson5.services;

import com.example.lesson5.dto.RequestProductReq;
import com.example.lesson5.dto.ResponseBodyAgreementDto;

public interface ProductServices {

    ResponseBodyAgreementDto createProduct(RequestProductReq req);

    ResponseBodyAgreementDto changeProduct(RequestProductReq req);
}
