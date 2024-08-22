package com.shubham.customer.customer;

import com.shubham.customer.customer.documents.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
