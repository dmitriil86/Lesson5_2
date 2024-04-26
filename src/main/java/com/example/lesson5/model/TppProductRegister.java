package com.example.lesson5.model;

import com.example.lesson5.enums.AccountState;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TppProductRegister {

    @Id
    @SequenceGenerator(name = "id_generator", sequenceName = "id_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id")
    private Integer id;

    @Column(length = 100, name = "value", unique = true)
    private String value;

    @Column(name = "product_id")
    private Integer productId;

   // @Column(name = "type")
    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "value")
    private TppRefProductRegisterType productRegisterType;

    @Column(name = "account")
    private Long account;

    @Column(name = "currency_code", length = 30)
    private String currencyCode;

    private AccountState state;

    @Column(name = "account_number", length = 25)
    private String accountNumber;

}
