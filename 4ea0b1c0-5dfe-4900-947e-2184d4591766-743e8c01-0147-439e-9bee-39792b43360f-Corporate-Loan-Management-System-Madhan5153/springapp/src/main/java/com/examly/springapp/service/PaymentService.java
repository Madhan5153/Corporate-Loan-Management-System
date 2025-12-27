package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Loan;
import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.LoanRepo;
import com.examly.springapp.repository.PaymentRepo;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepo paymentRepo;
  
  @Autowired
  private LoanRepo loanRepo;
  
  public Payment storePayment(Payment c){
    Optional<Loan> l=loanRepo.findById(c.getLoan().getLoanId());
    if(l.isPresent()) c.setLoan(l.get());
    return paymentRepo.save(c);
  }

  public Optional<Payment> getPaymentById(long paymentId){
    return paymentRepo.findById(paymentId);
  }

  public List<Payment> getAllPayments(){
    return paymentRepo.findAll();
  }

  public Payment updatPayment(long paymentId,Payment c){
    c.setPaymentId(paymentId);
    return paymentRepo.save(c);
  }

  public void deleteById(long paymentId){
      paymentRepo.deleteById(paymentId);
  }
}
