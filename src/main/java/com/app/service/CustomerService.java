package com.app.service;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  public Optional<Customer> getCustomerById (Integer id) {
    return customerRepository.findById(id);
  }

  public String registerCustomer (Customer customer) {
    customerRepository.save(customer);
    return "customer is successfully registered";
  }

  public String deleteCustomerById (Integer id) {
    customerRepository.deleteById(id);
    return "customer is successfully deleted";
  }

  public String updateOrSaveCustomer (Customer customer) {
    customerRepository.save(customer);
    return "customer is successfully updated";
  }

  public List<Customer> getAllCustomer() {
    return customerRepository.findAll();
  }
}
