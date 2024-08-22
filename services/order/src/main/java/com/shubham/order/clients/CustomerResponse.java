package com.shubham.order.clients;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {

}