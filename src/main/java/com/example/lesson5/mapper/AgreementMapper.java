package com.example.lesson5.mapper;

import com.example.lesson5.dto.instanceArrangementDto;
import com.example.lesson5.model.Agreement;
import com.example.lesson5.model.TppProduct;
import jakarta.persistence.SqlResultSetMappings;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AgreementMapper {

    @Named("toAgreementList")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "number", source = "instanceArrangementDto.number")
    @Mapping(target = "productId", ignore = true)
    Agreement toAgreement(instanceArrangementDto instanceArrangementDto);

    @IterableMapping(qualifiedByName = "toAgreementList")
    List<Agreement> toAgreementList(List<instanceArrangementDto> instanceArrangementDto);
}
