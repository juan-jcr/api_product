package com.pharmanet.pharmanet.presentation.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductDto {
    private Long id;
    @NotBlank(message = "el campo nombre es obligatorio")
    private String name;
    @NotNull(message = "el campo precio es obligatorio")
    private BigDecimal price;
    private LocalDate expirationDate;
    private String description;

    public ProductDto(Long id, String name, BigDecimal price, LocalDate expirationDate, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        this.description = description;
    }
    public ProductDto(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
