package com.vitaliy.zhakun.smartphones.controller;

import com.vitaliy.zhakun.smartphones.model.Customer;
import com.vitaliy.zhakun.smartphones.model.Manager;
import com.vitaliy.zhakun.smartphones.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/add/all")
    public ResponseEntity<List<Customer>> createCustomers(@RequestBody Iterable<Customer> customers) {
        List<Customer> savedCustomers = customerService.addCustomers(customers);
        return new ResponseEntity<List<Customer>>(savedCustomers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long id) {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") Long id) {
        Customer deletedCustomer = customerService.getCustomerById(id);
        customerService.deleteCustomerById(id);
        return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
    }
}
