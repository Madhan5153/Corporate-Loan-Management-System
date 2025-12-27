package com.examly.springapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Customer;
import com.examly.springapp.repository.CustomerRepo;

@Service
public class CustomerService {
    
  @Autowired
  private CustomerRepo repo;
  
  public Customer storeCustomer(Customer c){
    return repo.save(c);
  }

  public Optional<Customer> getCustomerById(long customerId){
    return repo.findById(customerId);
  }

  public List<Customer> getAllCustomers(){
    return repo.findAll();
  }

  public Customer updateCustomer(long customerId,Customer c){
    c.setCustomerId(customerId);
    return repo.save(c);
  }

  public void deleteById(long customerId){
      repo.deleteById(customerId);
  }

  public Page<Customer> getCustomersWithPagable(Pageable pageable){
    return repo.findAll(pageable);
  }

  public Optional<Customer> getCustomerByEmail(String email){
    return repo.findByEmail(email);
  }

  public List<Customer> getCustomersByCreditScore(double creditScore){
    return repo.findByCreditScoreGreaterThanEqual(creditScore);
  }

}
