package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.examly.springapp.model.Payment;
import com.examly.springapp.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

  @Autowired
  private PaymentService service;

  @PostMapping
  public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
    return new ResponseEntity<>(service.storePayment(payment),HttpStatus.CREATED);
  }

  @GetMapping("/{paymentId}")
  public ResponseEntity<Payment> getPaymentById(@PathVariable long paymentId){
    Optional<Payment> payment = service.getPaymentById(paymentId);
    return payment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<Payment>> getAllPayments(){
    List<Payment> payment=service.getAllPayments();
    return new ResponseEntity<>(payment,HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Payment> updatePayment(@PathVariable long id,@RequestBody Payment payment){
    Payment upPayment=service.updatPayment(id, payment);
    return new ResponseEntity<>(upPayment,HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePayment(@PathVariable long id){
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
