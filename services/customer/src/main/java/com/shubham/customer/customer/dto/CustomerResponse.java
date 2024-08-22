package com.shubham.customer.customer.dto;

import com.shubham.customer.customer.documents.Address;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {

}
