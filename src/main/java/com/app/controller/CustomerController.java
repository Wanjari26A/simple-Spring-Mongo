package com.app.controller;

import com.app.model.Customer;
import com.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @GetMapping("/customer/{adharNo}")
  private Optional<Customer> getCustomerByid (@PathVariable("adharNo") Integer id) {
    return customerService.getCustomerById(id);
  }

  @PostMapping("/customer")
  private String registerCustomer (@RequestBody Customer customer) {
    return customerService.registerCustomer(customer);
  }

  @PutMapping("/customer")
  private String updateCustomer (@RequestBody Customer customer) {
    return customerService.updateOrSaveCustomer(customer);
  }

  @DeleteMapping("/customer/{adharNo}")
  private String deleteCustomer (@PathVariable("adharNo") Integer id) {
    return customerService.deleteCustomerById(id);
  }

  @GetMapping("/customer")
  private List<Customer> getAllCustomer () {
    return customerService.getAllCustomer();
  }

}
