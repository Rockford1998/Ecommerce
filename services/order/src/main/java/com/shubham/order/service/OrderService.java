package com.shubham.order.service;


import com.shubham.order.clients.CustomerClient;
import com.shubham.order.dto.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    public Integer createOrder(OrderRequest request) {
        // check the customer ---> OpenFeign

        // purechase the product ---> product-ms
        // persist order
        // start payment process
        // send the order confirmatiom---> (kafka)
        return null;
    }
}
