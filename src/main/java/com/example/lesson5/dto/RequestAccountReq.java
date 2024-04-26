package com.example.lesson5.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class RequestAccountReq {

    @NotNull(message = "Обязательное поле instanceId не заполнено!!!")
    private Integer instanceId;

    private String registryTypeCode;

    private String accountType;

    private String currencyCode;

    private String branchCode;

    private String priorityCode;

    private String mdmCode;

    private String clientCode;

    private String trainRegion;

    private String counter;

    private String salesCode;
}
