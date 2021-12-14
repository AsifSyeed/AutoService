package com.example.autoservice.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> optionalCustomer =  customerRepository.findCustomerById(customer.getId());
        if (optionalCustomer.isPresent()) {
            throw new IllegalStateException("Customer Already Exists. Create a new ID");
        }
        customerRepository.save(customer);
    }
}
