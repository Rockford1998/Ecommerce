package com.shubham.product.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest (
        Integer id,
        @NotNull(message = "Product name is required.")
         String name,
        @NotNull(message = "Product description is required.")
         String description,
        @Positive(message = "Product available quantity is required and should not be zero.")
         double availableQuantity,
        @Positive(message = "Product price should not be less than 0.")

         BigDecimal price,
        @NotNull(message = "Product category is required.")
         Integer categoryId
){
}
