package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Customer;
import com.examly.springapp.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
  @Autowired
  private CustomerService service;

  @PostMapping
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
    return new ResponseEntity<>(service.storeCustomer(customer),HttpStatus.CREATED);
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable long customerId){
    Optional<Customer> customer = service.getCustomerById(customerId);
    return customer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<Customer>> getAllCustomers(){
    List<Customer> customer=service.getAllCustomers();
    return new ResponseEntity<>(customer,HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody Customer customer){
    Customer upCustomer=service.updateCustomer(id, customer);
    return new ResponseEntity<>(upCustomer,HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable long id){
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/page/{offset}/{range}")
  public ResponseEntity<Page<Customer>> getCustomersWithPagination(@PathVariable int offset,@PathVariable int range){
    Pageable pageable=PageRequest.of(offset,range);
    Page<Customer> page=service.getCustomersWithPagable(pageable);
    return ResponseEntity.ok(page);
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<Object> getCustomerByEmail(@PathVariable String email){
    Optional<Customer> obj=service.getCustomerByEmail(email);
    if(obj.isPresent()){
      return ResponseEntity.ok(obj.get());
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with email: "+email);
  }
  @GetMapping("/creditScore/{creditScore}")
  public ResponseEntity<Object> getCustomersByCreditScore(@PathVariable double creditScore){
    List<Customer> customers=service.getCustomersByCreditScore(creditScore);
    if(customers.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customers found with credit score >= "+creditScore);
    return ResponseEntity.ok(customers);
  } 
}