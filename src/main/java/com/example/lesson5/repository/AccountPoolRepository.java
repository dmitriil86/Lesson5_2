package com.example.lesson5.repository;

import com.example.lesson5.model.AccountPool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountPoolRepository extends JpaRepository<AccountPool,Integer> {

    List<AccountPool> findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode(String branchCode, String currencyCode, String mdmCode, String priorityCode, String registryTypeCode);
}
