package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Customer;
import com.examly.springapp.model.Loan;
import com.examly.springapp.model.LoanType;
import com.examly.springapp.repository.CustomerRepo;
import com.examly.springapp.repository.LoanRepo;
import com.examly.springapp.repository.LoanTypeRepo;

@Service
public class LoanService {

  @Autowired
  private LoanRepo loanRepo;

  @Autowired
  private CustomerRepo customerRepo;
  
  @Autowired
  private LoanTypeRepo loanTypeRepo;
  
  public Loan storeLoan(Loan loan){
    Optional<Customer> c=customerRepo.findById(loan.getCustomer().getCustomerId());
    Optional<LoanType> l=loanTypeRepo.findById(loan.getLoanType().getLoanTypeId());
    if(c.isPresent()) loan.setCustomer(c.get());
    if(l.isPresent()) loan.setLoanType(l.get());
    return loanRepo.save(loan);
  }

  public Optional<Loan> getLoanById(long loanId){
    return loanRepo.findById(loanId);
  }

  public List<Loan> getAllLoans(){
    return loanRepo.findAll();
  }

  public Loan updatLoan(long loanId,Loan c){
    c.setLoanId(loanId);
    return loanRepo.save(c);
  }

  public void deleteById(long loanId){
      loanRepo.deleteById(loanId);
  }

  public List<Loan> getLoansByStatus(String status){
    return loanRepo.findByStatus(status);
  }
}
