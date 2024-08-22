package com.shubham.product.dto;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "product id is required")
        Integer productId,
        @NotNull(message = "quantity id is required")
        Double quantity
) {
}
