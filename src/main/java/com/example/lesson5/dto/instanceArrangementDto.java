package com.example.lesson5.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class instanceArrangementDto {

    private String generalAgreementId;

    private String supplementaryAgreementId;

    private String arrangementType;

    private Integer shedulerJobId;

    @NotNull(message = "Обязательное поле instanceArrangement.Number не заполнено!!!")
    @Schema(example = "123")
    private String number;

    @NotNull(message = "Обязательное поле instanceArrangement.openingDate не заполнено!!!")
    @Schema(example = "2024-01-01")
    private Date openingDate;

    private Date closingDate;

    private Date CancelDate;

    private Integer validityDuration;

    private String cancellationReason;

    private String Status;

    private Date interestCalculationDate;

    private Float interestRate;

    private Float coefficient;

    private String coefficientAction;

    private Float minimumInterestRate;

    @Schema(example = "0")
    private String minimumInterestRateCoefficient;

    private String minimumInterestRateCoefficientAction;

    private BigDecimal maximalInterestRate;

    private BigDecimal maximalInterestRateCoefficient;

    private String maximalInterestRateCoefficientAction;


}
