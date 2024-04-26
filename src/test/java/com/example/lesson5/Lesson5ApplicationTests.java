package com.example.lesson5;

import com.example.lesson5.dto.RequestAccountReq;
import com.example.lesson5.exceptions.BadRequestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
@ComponentScan(basePackages = "com/example/lesson5")
@AutoConfigureMockMvc
@DirtiesContext
class Lesson5ApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    MockMvc restCRUDLAgrement;

    @SneakyThrows
    @Test
    void BadRequest() {

        String jsonStr = "{\n" +
                "  \"registryTypeCode\": \"03.012.002_47533_ComSoLd\",\n" +
                "  \"accountType\": \"string\",\n" +
                "  \"currencyCode\": \"800\",\n" +
                "  \"branchCode\": \"0022\",\n" +
                "  \"priorityCode\": \"00\",\n" +
                "  \"mdmCode\": \"15\",\n" +
                "  \"clientCode\": \"string\",\n" +
                "  \"trainRegion\": \"string\",\n" +
                "  \"counter\": \"string\",\n" +
                "  \"salesCode\": \"string\"\n" +
                "}";

        RequestAccountReq accountReq = objectMapper.readValue(jsonStr, RequestAccountReq.class);

        restCRUDLAgrement.perform(post("http://localhost:8080/corporate-settlement-account/create").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));

        System.out.println(accountReq.getAccountType());
    }

    @SneakyThrows
    @Test
    void NiceRequest() {

        String jsonStr = "{\n" +
                "\"instanceId\": 1,"+
                "  \"registryTypeCode\": \"03.012.002_47533_ComSoLd\",\n" +
                "  \"accountType\": \"string\",\n" +
                "  \"currencyCode\": \"800\",\n" +
                "  \"branchCode\": \"0022\",\n" +
                "  \"priorityCode\": \"00\",\n" +
                "  \"mdmCode\": \"15\",\n" +
                "  \"clientCode\": \"string\",\n" +
                "  \"trainRegion\": \"string\",\n" +
                "  \"counter\": \"string\",\n" +
                "  \"salesCode\": \"string\"\n" +
                "}";


        restCRUDLAgrement.perform(post("http://localhost:8080/corporate-settlement-account/create").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andExpect(status().isOk()).andReturn();

    }

    @SneakyThrows
    @Test
    void testProduct()
    {
        String jsonStr = "{\n" +
                "  \"productType\": \"03.012.002\",\n" +
                "  \"productCode\": \"03.012.002\",\n" +
                "  \"registerType\": \"InternalId\",\n" +
                "  \"mdmCode\": \"12345678\",\n" +
                "  \"contractNumber\": \"475000\",\n" +
                "  \"contractDate\": \"2024-04-26T14:21:43.512Z\",\n" +
                "  \"priority\": 2,\n" +
                "  \"interestRatePenalty\": 0,\n" +
                "  \"minimalBalance\": 0,\n" +
                "  \"thresholdAmount\": 0,\n" +
                "  \"accountingDetails\": \"string\",\n" +
                "  \"rateType\": \"string\",\n" +
                "  \"taxPercentageRate\": 0,\n" +
                "  \"technicalOverdraftLimitAmount\": 0,\n" +
                "  \"contractId\": 1,\n" +
                "  \"urgencyCode\": \"500\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"key\": \"string\",\n" +
                "      \"value\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"instanceArrangement\": [\n" +
                "    {\n" +
                "      \"generalAgreementId\": \"string\",\n" +
                "      \"supplementaryAgreementId\": \"string\",\n" +
                "      \"arrangementType\": \"string\",\n" +
                "      \"shedulerJobId\": 0,\n" +
                "      \"number\": \"123\",\n" +
                "      \"openingDate\": \"2024-04-26T14:21:43.513Z\",\n" +
                "      \"closingDate\": \"2024-04-26T14:21:43.513Z\",\n" +
                "      \"validityDuration\": 0,\n" +
                "      \"cancellationReason\": \"string\",\n" +
                "      \"interestCalculationDate\": \"2024-04-26T14:21:43.513Z\",\n" +
                "      \"interestRate\": 0,\n" +
                "      \"coefficient\": 0,\n" +
                "      \"coefficientAction\": \"string\",\n" +
                "      \"minimumInterestRate\": 0,\n" +
                "      \"minimumInterestRateCoefficient\": \"0\",\n" +
                "      \"minimumInterestRateCoefficientAction\": \"string\",\n" +
                "      \"maximalInterestRate\": 0,\n" +
                "      \"maximalInterestRateCoefficient\": 0,\n" +
                "      \"maximalInterestRateCoefficientAction\": \"string\",\n" +
                "      \"status\": \"string\",\n" +
                "      \"cancelDate\": \"2024-04-26T14:21:43.513Z\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"branchCode\": \"string\",\n" +
                "  \"isoCurrencyCode\": \"string\",\n" +
                "  \"referenceCode\": 0\n" +
                "}";

        restCRUDLAgrement.perform(post("http://localhost:8080/corporate-settlement-instance/create").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andExpect(status().isOk()).andReturn();

    }

    @SneakyThrows
    @Test
    void testBedProduct()
    {
        String jsonStr = "{\n" +
                "  \"registerType\": \"InternalId\",\n" +
                "  \"mdmCode\": \"12345678\",\n" +
                "  \"contractNumber\": \"475000\",\n" +
                "  \"contractDate\": \"2024-04-26T14:21:43.512Z\",\n" +
                "  \"priority\": 2,\n" +
                "  \"interestRatePenalty\": 0,\n" +
                "  \"minimalBalance\": 0,\n" +
                "  \"thresholdAmount\": 0,\n" +
                "  \"accountingDetails\": \"string\",\n" +
                "  \"rateType\": \"string\",\n" +
                "  \"taxPercentageRate\": 0,\n" +
                "  \"technicalOverdraftLimitAmount\": 0,\n" +
                "  \"contractId\": 1,\n" +
                "  \"urgencyCode\": \"500\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"key\": \"string\",\n" +
                "      \"value\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"instanceArrangement\": [\n" +
                "    {\n" +
                "      \"generalAgreementId\": \"string\",\n" +
                "      \"supplementaryAgreementId\": \"string\",\n" +
                "      \"arrangementType\": \"string\",\n" +
                "      \"shedulerJobId\": 0,\n" +
                "      \"number\": \"123\",\n" +
                "      \"openingDate\": \"2024-04-26T14:21:43.513Z\",\n" +
                "      \"closingDate\": \"2024-04-26T14:21:43.513Z\",\n" +
                "      \"validityDuration\": 0,\n" +
                "      \"cancellationReason\": \"string\",\n" +
                "      \"interestCalculationDate\": \"2024-04-26T14:21:43.513Z\",\n" +
                "      \"interestRate\": 0,\n" +
                "      \"coefficient\": 0,\n" +
                "      \"coefficientAction\": \"string\",\n" +
                "      \"minimumInterestRate\": 0,\n" +
                "      \"minimumInterestRateCoefficient\": \"0\",\n" +
                "      \"minimumInterestRateCoefficientAction\": \"string\",\n" +
                "      \"maximalInterestRate\": 0,\n" +
                "      \"maximalInterestRateCoefficient\": 0,\n" +
                "      \"maximalInterestRateCoefficientAction\": \"string\",\n" +
                "      \"status\": \"string\",\n" +
                "      \"cancelDate\": \"2024-04-26T14:21:43.513Z\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"branchCode\": \"string\",\n" +
                "  \"isoCurrencyCode\": \"string\",\n" +
                "  \"referenceCode\": 0\n" +
                "}";

        restCRUDLAgrement.perform(post("http://localhost:8080/corporate-settlement-instance/create").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));

    }

}
