package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.Customer;
import com.vitaliy.zhakun.smartphones.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty())
            throw new IllegalStateException("Customer with Id = " + id + " does not exist.");
        return optionalCustomer.get();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());
        if (optionalCustomer.isEmpty())
            throw new IllegalStateException("Customer with Id = " + customer.getId() + " is already exist in Database.");
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> addCustomers(Iterable<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty())
            throw new IllegalStateException("Customer with Id = " + id + " does not exist.");
        else
            customerRepository.deleteById(id);

    }
}
