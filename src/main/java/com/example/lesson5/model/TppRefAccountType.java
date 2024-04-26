package com.example.lesson5.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Entity
@Data
public class TppRefAccountType {

    @Id
    @SequenceGenerator(name = "id_generator", sequenceName = "id_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "internal_id")
    private Integer internalId;

    @Column(length = 100, name = "value", unique = true, nullable = false)
    private String value;

}
