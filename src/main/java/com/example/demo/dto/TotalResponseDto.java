package com.example.demo.dto;

import java.math.BigDecimal;

public class TotalResponseDto {

    private BigDecimal total;
    private String category;

    public TotalResponseDto(BigDecimal total, String category) {
        this.total = total;
        this.category = category;
    }

    public BigDecimal getTotal() { return total; }
    public String getCategory() { return category; }
}