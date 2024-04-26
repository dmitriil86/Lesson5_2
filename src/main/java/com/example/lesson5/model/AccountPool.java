package com.example.lesson5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class AccountPool {

    @Id
    @SequenceGenerator(name = "id_generator", sequenceName = "id_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "accountPoolId",cascade = CascadeType.ALL)
    private List<Account> accountList;

    @Column(name = "branch_code", length = 50)
    private String branchCode;

    @Column(name = "currency_code", length = 30)
    private String currencyCode;

    @Column(name = "mdm_code", length = 50)
    private String mdmCode;

    @Column(name = "priority_code",length = 30)
    private String priorityCode;

    @Column(name = "registry_type_code", length = 50)
    private String registryTypeCode;
}
