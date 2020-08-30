package com.app.service;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  private static final Logger logger = Logger.getLogger(CustomerService.class);

  public Optional<Customer> getCustomerById (Integer id) {
      Boolean CustomerIsPresent = false;
      Optional<Customer> customer = customerRepository.findById(id);
      if (customer.isPresent()) {
        logger.info(" Customer having AdharCardNo: "+id+ "is found having details: "+customer.get());
      } else {
        logger.info(" Customer having AdharCardNo: "+id+ "is not found ! ");
      }
      return customer;
  }

  public String registerCustomer (Customer customer) {
    customerRepository.save(customer);
    logger.info("customer having AdharCardNo :"+customer.getAdharNo()+"is successfully registered");
    return "customer having AdharCardNo :"+customer.getAdharNo()+"is successfully registered";
  }

  public String deleteCustomerById (Integer id) {

    customerRepository.deleteById(id);
    logger.info("customer having AdharCardNo :"+id+"is successfully deleted ");
    return "customer is successfully deleted";
  }

  public String updateOrSaveCustomer (Customer customer) {
    customerRepository.save(customer);
    logger.info("customer having AdharCardNo :"+customer.getAdharNo()+" is successfully updated");
    return "customer having AdharCardNo :"+customer.getAdharNo()+" is successfully updated";
  }

  public List<Customer> getAllCustomer() {
    try {
      List<Customer> customers = customerRepository.findAll();
      logger.info("GET all customers");
      return customers;
    } catch (Error e) {
      throw e;
    }
  }
}
