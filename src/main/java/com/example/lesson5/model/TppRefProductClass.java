package com.example.lesson5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TppRefProductClass {

    @Column(name = "internal_id")
    private Integer internalId;

    @Id
    @Column(length = 100, name = "value", unique = true, nullable = false)
    private String value;

    @Column(length = 50, name = "gbi_code")
    private String gbiCode;

    @Column(length = 100, name = "gbi_name")
    private String gbiName;

    @Column(length = 50, name = "product_row_code")
    private String productRowCode;

    @Column(length = 100, name = "product_row_name")
    private String productRowName;

    @Column(length = 50, name = "subclass_code")
    private String subclassCode;

    @Column(length = 100, name = "subclass_name")
    private String subclassName;




}
