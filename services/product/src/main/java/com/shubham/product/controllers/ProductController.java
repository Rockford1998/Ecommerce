package com.shubham.product.controllers;

import com.shubham.product.dto.ProductPurchaseRequest;
import com.shubham.product.dto.ProductPurchaseResponse;
import com.shubham.product.dto.ProductRequest;
import com.shubham.product.dto.ProductResponse;
import com.shubham.product.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping("/")
    public ResponseEntity<Integer> createProduct(
            @RequestBody() @Valid ProductRequest request
    ) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @PostMapping("/purchases")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(
            @RequestBody List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId) {
        return ResponseEntity.ok(service.FindById(productId));
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(service.FindAll());
    }


}
