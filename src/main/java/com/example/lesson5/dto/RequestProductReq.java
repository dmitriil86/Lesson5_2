package com.example.lesson5.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RequestProductReq {

    private Integer instanceId;

    @NotNull(message = "Обязательное поле productType не заполнено!!!")
    @Schema(example = "03.012.002")
    private String productType;

    @NotNull(message = "Обязательное поле productCode не заполнено!!!")
    @Schema(example = "03.012.002")
    private String productCode;

    @NotNull(message = "Обязательное поле registerType не заполнено!!!")
    @Schema(example = "InternalId")
    private String registerType;

    @NotNull(message = "Обязательное поле mdmCode не заполнено!!!")
    @Schema(example = "12345678")
    private String mdmCode;

    @NotNull(message = "Обязательное поле contractNumber не заполнено!!!")
    @Schema(example = "475000")
    private String contractNumber;

    @NotNull(message = "Обязательное поле contractDate не заполнено!!!")
    @Schema(example = "2024-01-01")
    private Date contractDate;

    @NotNull(message = "Обязательное поле priority не заполнено!!!")
    @Schema(example = "2")
    private Integer priority;

    private Float interestRatePenalty;

    private Float minimalBalance;

    private Float thresholdAmount;

    private String accountingDetails;

    private String rateType;

    private Float taxPercentageRate;

    private Float technicalOverdraftLimitAmount;

    @NotNull(message = "Обязательное поле contractId не заполнено!!!")
    @Schema(example = "1")
    private Integer contractId;

    @NotNull(message = "Обязательное поле BranchCode не заполнено!!!")
    @Schema(example = "102")
    private String BranchCode;

    @NotNull(message = "Обязательное поле IsoCurrencyCode не заполнено!!!")
    @Schema(example = "RUB")
    private String IsoCurrencyCode;

    @NotNull(message = "Обязательное поле urgencyCode не заполнено!!!")
    @Schema(example = "500")
    private String urgencyCode;

    private Integer ReferenceCode;

    private List<additionalPropertiesVipDto> data;

    private List<instanceArrangementDto> instanceArrangement;

}
