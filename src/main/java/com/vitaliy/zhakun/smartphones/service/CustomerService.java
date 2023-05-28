package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer addCustomer(Customer customer);

    List<Customer> addCustomers(Iterable<Customer> customers);

    Customer updateCustomer(Customer customer, Long id);

    void deleteCustomerById(Long id);
}
