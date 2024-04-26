package com.example.lesson5.controllers;

import com.example.lesson5.dto.RequestProductReq;
import com.example.lesson5.dto.ResponseBodyAgreementDto;
import com.example.lesson5.interfaces.ProductInterface;
import com.example.lesson5.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ProductInterfaceImp implements ProductInterface {

    private final ProductServices productServices;
    @Override
    public ResponseBodyAgreementDto createProduct(RequestProductReq req) {


        if(req.getInstanceId() == null)
        {
            return productServices.createProduct(req);
        }
        else
        {
            return productServices.changeProduct(req);
        }

    }
}
