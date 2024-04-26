package com.example.lesson5.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class TppProduct {

    @Id
    @SequenceGenerator(name = "id_generator", sequenceName = "id_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL)
    private List<Agreement> agreementId;

    @Column(name = "product_code_id")
    private String productCodeId;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "number", length = 50)
    private String number;

    @Column(name = "priority")
    private Long priority;

    @Column(name = "date_of_conclusion")
    private Timestamp dateOfConclusion;

    @Column(name = "start_date_time")
    private Timestamp startDateTime;

    @Column(name = "end_date_time")
    private Timestamp endDateTime;

    @Column(name = "days")
    private Long days;

    @Column(name = "penalty_rate")
    private BigDecimal penaltyRate;

    @Column(name = "nso")
    private BigDecimal nso;

    @Column(name = "threshold_amount")
    private BigDecimal thresholdAmount;

    @Column(name = "requisite_type", length = 50)
    private String requisiteType;

    @Column(name = "interest_rate_type", length = 50)
    private String interestRateType;

    @Column(name = "tax_rate")
    private BigDecimal tax_rate;

    @Column(name = "reasone_close", length = 100)
    private String reasoneClose;

    @Column(name = "state", length = 50)
    private String state;

}
