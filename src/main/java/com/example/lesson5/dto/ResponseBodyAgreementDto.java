package com.example.lesson5.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseBodyAgreementDto {

    private String instanceId;

    private List<String> registerId;

    private List<String> supplementaryAgreementId;


}
