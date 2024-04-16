package com.example.carprice.dto;

import lombok.Value;
import java.math.BigDecimal;

@Value
public class AnnounceDto {
    String brand;
    String color;
    BigDecimal price;
    String model;
}
