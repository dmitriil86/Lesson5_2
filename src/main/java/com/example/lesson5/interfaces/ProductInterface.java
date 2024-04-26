package com.example.lesson5.interfaces;

import com.example.lesson5.dto.RequestProductReq;
import com.example.lesson5.dto.ResponseBodyAgreementDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/corporate-settlement-instance")
public interface ProductInterface {

    @PostMapping("/create")
    ResponseBodyAgreementDto createProduct(@Valid @RequestBody RequestProductReq req);
}
