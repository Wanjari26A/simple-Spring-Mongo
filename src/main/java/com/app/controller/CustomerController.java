package com.app.controller;

import com.app.model.Customer;
import com.app.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class CustomerController {

  @Autowired
  CustomerService customerService;

  private static final Logger logger = Logger.getLogger(CustomerController.class);


  @GetMapping("/customer/{adharNo}")
  private Optional<Customer> getCustomerByid (@PathVariable("adharNo") Integer id) {
    logger.info("GET [Customer] ");
    return customerService.getCustomerById(id);
  }

  @PostMapping("/customer")
  private String registerCustomer (@RequestBody Customer customer) {
    logger.info("CREATE [Customer] ");
    return customerService.registerCustomer(customer);
  }

  @PutMapping("/customer")
  private String updateCustomer (@RequestBody Customer customer) {
    logger.info("UPDATE [Customer] ");
    return customerService.updateOrSaveCustomer(customer);
  }

  @DeleteMapping("/customer/{adharNo}")
  private String deleteCustomer (@PathVariable("adharNo") Integer id) {
    logger.info("DELETE [Customer] ");
    return customerService.deleteCustomerById(id);
  }

  @GetMapping("/customer")
  private List<Customer> getAllCustomer () {
    logger.info("GET ALL [Customer] ");
    return customerService.getAllCustomer();
  }

}
