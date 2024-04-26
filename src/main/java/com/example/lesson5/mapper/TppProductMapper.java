package com.example.lesson5.mapper;

import com.example.lesson5.dto.RequestProductReq;
import com.example.lesson5.model.TppProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TppProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "agreementId",ignore = true)
    @Mapping(target = "productCodeId",source = "req.productCode")
    @Mapping(target = "clientId",source = "req.mdmCode")
    @Mapping(target = "type",source = "req.productType")
    @Mapping(target = "number",source = "req.contractNumber")
    @Mapping(target = "dateOfConclusion",source = "req.contractDate")
    @Mapping(target = "startDateTime",source = "req.contractDate")
    @Mapping(target = "endDateTime",ignore = true)
    @Mapping(target = "days",ignore = true)
    @Mapping(target = "penaltyRate",ignore = true)
    @Mapping(target = "nso",ignore = true)
    @Mapping(target = "requisiteType",ignore = true)
    @Mapping(target = "interestRateType",ignore = true)
    @Mapping(target = "tax_rate",source = "req.taxPercentageRate")
    @Mapping(target = "reasoneClose",ignore = true)
    @Mapping(target = "state",ignore = true)
    TppProduct toTppProduct(RequestProductReq req);
}
