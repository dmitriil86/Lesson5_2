package com.example.lesson5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.sql.Timestamp;

@Entity
@Data
public class TppRefProductRegisterType {

    @Column(name = "internal_id")
    private Integer internalId;

    //@Column(length = 100, name = "value", unique = true, nullable = false)
    @Id
    private String value;

    @Column(length = 100, name = "register_type_name", nullable = false)
    private String registerTypeName;

//    @Column(length = 100, name = "product_class_code", nullable = false)
    @ManyToOne
    @JoinColumn(name = "product_class_code", referencedColumnName = "value")
    private TppRefProductClass productClassCode;

    @Column(name = "register_type_start_date")
    private Timestamp registerTypeStartDate;

    @Column(name = "register_type_end_date")
    private Timestamp registerTypeEndDate;

   // @Column(name = "account_type ", length = 100)
    @ManyToOne
    @JoinColumn(name = "account_type", referencedColumnName = "value")
    private TppRefAccountType accountType;
}
