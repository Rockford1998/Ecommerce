package com.shubham.customer.customer;

import com.shubham.customer.customer.documents.Customer;
import com.shubham.customer.customer.dto.CustomerRequest;
import com.shubham.customer.customer.dto.CustomerResponse;
import com.shubham.customer.customer.mapper.CustomerMapper;
import com.shubham.customer.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        Customer customer = repository.save(mapper.toCustomer(request));
        return customer.getId();

    }

    public void updateCustomer(CustomerRequest request) {
        Customer customer = repository.findById(request.id()).orElseThrow(() -> new CustomerNotFoundException(
                String.format("Cannot update customer:: No customer found with provided Id :: %s", request.id())
        ));
        mergerCustomer(customer, request);
        repository.save(customer);

    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        ;
        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        ;
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        ;
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
        ;
    }

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existById(String customerId) {
        return repository.findById(customerId).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId).map(mapper::fromCustomer).orElseThrow(()->new CustomerNotFoundException("No customer found with provided Id :: " + customerId));
    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
