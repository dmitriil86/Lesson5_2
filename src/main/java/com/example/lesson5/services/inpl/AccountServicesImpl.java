package com.example.lesson5.services.inpl;

import com.example.lesson5.dto.RequestAccountReq;
import com.example.lesson5.dto.ResponseBodyAccountDto;
import com.example.lesson5.enums.AccountState;
import com.example.lesson5.exceptions.BadRequestException;
import com.example.lesson5.exceptions.NotFoundException;
import com.example.lesson5.model.AccountPool;
import com.example.lesson5.model.TppProductRegister;
import com.example.lesson5.model.TppRefProductRegisterType;
import com.example.lesson5.repository.AccountPoolRepository;
import com.example.lesson5.repository.TppProductRegisterRepository;
import com.example.lesson5.repository.TppRefProductRegisterTypeRepository;
import com.example.lesson5.services.AccountServices;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountServicesImpl implements AccountServices {

    private final TppProductRegisterRepository tppProductRegisterRepository;
    private final TppRefProductRegisterTypeRepository tppRefProductRegisterTypeRepository;
    private final AccountPoolRepository accountPoolRepository;


    @SneakyThrows
    @Override
    public ResponseBodyAccountDto cheсkAccountReq(RequestAccountReq accountReq) {

        TppRefProductRegisterType tppRefProductRegisterType = tppRefProductRegisterTypeRepository.findByValue(accountReq.getRegistryTypeCode());
        if(tppRefProductRegisterType == null)
        {
            throw new NotFoundException("Код Продукта "+accountReq.getRegistryTypeCode()+" не найдено в Каталоге продуктов postgres.tpp_ref_product_register_type для данного типа Регистра");
        }

        List<TppProductRegister> tppProductRegister = tppProductRegisterRepository.findByProductIdAndProductRegisterType(accountReq.getInstanceId(),tppRefProductRegisterType);

        if (tppProductRegister.size()>0)
        {
             throw new BadRequestException("Параметр registryTypeCode тип регистра "+accountReq.getRegistryTypeCode()+" уже существует для ЭП с ИД  "+accountReq.getInstanceId()+".");
        }

        List<AccountPool> accountPools = accountPoolRepository.findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(accountReq.getBranchCode(),accountReq.getCurrencyCode(),accountReq.getMdmCode(),accountReq.getPriorityCode(),accountReq.getRegistryTypeCode());

        if (accountPools.size()>0)
        {
            TppProductRegister newRegister = new TppProductRegister();
            newRegister.setProductId(accountReq.getInstanceId());
            newRegister.setProductRegisterType(tppRefProductRegisterType);
            newRegister.setAccount(Long.valueOf(accountPools.get(0).getAccountList().get(0).getId()));
            newRegister.setCurrencyCode(accountReq.getCurrencyCode());
            newRegister.setState(AccountState.valueOf("OPEN"));
            newRegister.setAccountNumber(accountPools.get(0).getAccountList().get(0).getAccountNumber());
            TppProductRegister newRegisters = tppProductRegisterRepository.save(newRegister);

            ResponseBodyAccountDto responseBodyAccountDto = new ResponseBodyAccountDto();
            responseBodyAccountDto.setAccountId(newRegisters.getId().toString());
            return responseBodyAccountDto;
        }
        else
        {
            throw new NotFoundException("accountPools не найден с параметрами BranchCode "+accountReq.getBranchCode()+", CurrencyCode "+accountReq.getCurrencyCode()+", MdmCode "+accountReq.getMdmCode()+", PriorityCode "+accountReq.getPriorityCode()+", RegistryTypeCode "+accountReq.getRegistryTypeCode());
        }

    }
}
