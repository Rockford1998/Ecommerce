package com.shubham.product.mapper;

import com.shubham.product.dto.ProductPurchaseResponse;
import com.shubham.product.dto.ProductRequest;
import com.shubham.product.dto.ProductResponse;
import com.shubham.product.entities.Category;
import com.shubham.product.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder().
                id(request.id()).
                name(request.name()).
                description(request.description()).
                price(request.price())
                .availableQuantity(request.availableQuantity())
                .category(Category.builder().
                        id(request.categoryId()).build())

                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toproductPurchaseResponse(Product product, Double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity

        );
    }
}
