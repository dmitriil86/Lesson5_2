package com.example.lesson5.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "1")
    private Integer instanceId;

    @Schema(example = "03.012.002_47533_ComSoLd")
    private String registryTypeCode;

    private String accountType;

    @Schema(example = "800")
    private String currencyCode;

    @Schema(example = "0022")
    private String branchCode;

    @Schema(example = "00")
    private String priorityCode;
    @Schema(example = "15")
    private String mdmCode;

    private String clientCode;

    private String trainRegion;

    private String counter;

    private String salesCode;
}
