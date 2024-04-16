package com.example.carprice.entity;

import lombok.Data;
import lombok.NonNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Announce {
    @NonNull
    private Integer id;
    @NonNull
    private String brand;
    @NonNull
    private String color;
    @NonNull
    private BigDecimal price;
    @NonNull
    private String model;
    @NonNull
    private LocalDate date;
}
