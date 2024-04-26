package com.example.lesson5.services.inpl;

import com.example.lesson5.dto.RequestProductReq;
import com.example.lesson5.dto.ResponseBodyAgreementDto;
import com.example.lesson5.dto.instanceArrangementDto;
import com.example.lesson5.exceptions.BadRequestException;
import com.example.lesson5.exceptions.NotFoundException;
import com.example.lesson5.mapper.AgreementMapper;
import com.example.lesson5.mapper.TppProductMapper;
import com.example.lesson5.model.*;
import com.example.lesson5.repository.*;
import com.example.lesson5.services.ProductServices;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServicesImpl implements ProductServices {

    private final TppProductRepository tppProductRepository;
    private final TppProductRegisterRepository tppProductRegisterRepository;
    private final AgreementRepository agreementRepository;
    private final TppRefProductClassRepository tppRefProductClassRepository;
    private final TppRefAccountTypeRepository tppRefAccountTypeRepository;
    private final TppRefProductRegisterTypeRepository tppRefProductRegisterTypeRepository;
    private final AgreementMapper agreementMapper;
    private final TppProductMapper tppProductMapper;

    @SneakyThrows
    @Override
    public ResponseBodyAgreementDto createProduct(RequestProductReq req) {

        TppProduct tppProduct = tppProductRepository.findByNumber(req.getContractNumber());

        if (tppProduct != null) {
            throw new BadRequestException("Параметр ContractNumber № договора " + req.getContractNumber() + " уже существует для ЭП с ИД  " + tppProduct.getId());
        }

        for (instanceArrangementDto instanceArrangementDto : req.getInstanceArrangement()) {
            Agreement agreement = agreementRepository.findByNumber(instanceArrangementDto.getNumber());

            if (agreement != null) {
                throw new BadRequestException("Параметр № Дополнительного соглашения (сделки) Number " + instanceArrangementDto.getNumber() + " уже существует для ЭП с ИД " + agreement.getId());
            }
        }

        TppRefProductClass tppRefProductClasses = tppRefProductClassRepository.findByValue(req.getProductCode());

        TppRefAccountType tppRefAccountType = tppRefAccountTypeRepository.findByValue("Клиентский");

        List<TppRefProductRegisterType> tppRefProductRegisterTypes = tppRefProductRegisterTypeRepository.findByProductClassCodeAndAccountType(tppRefProductClasses, tppRefAccountType);

        if (tppRefProductRegisterTypes.size() == 0) {
            throw new NotFoundException("Код Продукта " + req.getProductCode() + " не найдено в Каталоге продуктов tpp_ref_product_class");
        }

        tppProduct = tppProductMapper.toTppProduct(req);

        tppProduct = tppProductRepository.saveAndFlush(tppProduct);

        TppProductRegister tppProductRegister = new TppProductRegister();

        tppProductRegister.setProductId(tppProduct.getId());
        tppProductRegister.setProductRegisterType(tppRefProductRegisterTypes.get(0));
        tppProductRegister.setCurrencyCode(req.getIsoCurrencyCode());
        List<TppProductRegister> tppProductRegisters = tppProductRegisterRepository.findByProductId(req.getContractId());
        if (tppProductRegisters.size() > 0){
            tppProductRegister.setAccountNumber(tppProductRegisters.get(0).getAccountNumber());
        }
        else
        {
            throw new NotFoundException("Регистр не найден с id "+req.getContractId());
        }
        tppProductRegister = tppProductRegisterRepository.save(tppProductRegister);

        ResponseBodyAgreementDto responseBodyAgreementDto = new ResponseBodyAgreementDto();
        String instanceId = tppProduct.getId().toString();
        List<String> registerId = new ArrayList<>();

        registerId.add(tppProductRegister.getId().toString());

        responseBodyAgreementDto.setInstanceId(instanceId);
        responseBodyAgreementDto.setRegisterId(registerId);

        return responseBodyAgreementDto;
    }

    @SneakyThrows
    @Override
    public ResponseBodyAgreementDto changeProduct(RequestProductReq req) {

        TppProduct tppProduct = tppProductRepository.findById(req.getInstanceId()).orElse(null);

        if (tppProduct == null)
        {
            throw new NotFoundException("Экземпляр продукта с параметром instanceId "+req.getInstanceId()+" не найден.");
        }

        for(instanceArrangementDto instanceArrangementDto : req.getInstanceArrangement()) {
            Agreement agreement = agreementRepository.findByNumber(instanceArrangementDto.getNumber());

            if (agreement != null)
            {
                throw new BadRequestException("Параметр № Дополнительного соглашения (сделки) Number "+instanceArrangementDto.getNumber()+" уже существует для ЭП с ИД "+agreement.getId());
            }
        }

       List<Agreement> agreements = agreementMapper.toAgreementList(req.getInstanceArrangement());

        for (Agreement agreement: agreements)
        {
            agreement.setProductId(tppProduct);
        }

        agreements = agreementRepository.saveAll(agreements);

        ResponseBodyAgreementDto responseBodyAgreementDto = new ResponseBodyAgreementDto();
        String instanceId = tppProduct.getId().toString();
        List<String> agreementsId = new ArrayList<>();

        for (Agreement agreement : agreements)
        {
            agreementsId.add(agreement.getId().toString());
        }
        responseBodyAgreementDto.setInstanceId(instanceId);
        responseBodyAgreementDto.setSupplementaryAgreementId(agreementsId);

        return responseBodyAgreementDto;
    }
}
