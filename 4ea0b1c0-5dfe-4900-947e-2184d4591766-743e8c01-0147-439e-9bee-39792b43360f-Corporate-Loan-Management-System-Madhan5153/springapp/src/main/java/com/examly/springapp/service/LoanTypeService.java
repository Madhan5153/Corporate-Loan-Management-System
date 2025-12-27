package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.LoanType;
import com.examly.springapp.repository.LoanTypeRepo;

@Service
public class LoanTypeService {
    
  @Autowired
  private LoanTypeRepo loanTypeRepo;
  
  public LoanType storeLoanType(LoanType c){
    return loanTypeRepo.save(c);
  }

  public Optional<LoanType> getLoanTypeById(long loanTypeId){
    return loanTypeRepo.findById(loanTypeId);
  }

  public List<LoanType> getAllLoanTypes(){
    return loanTypeRepo.findAll();
  }

  public LoanType updatLoanType(long loanTypeId,LoanType c){
    c.setLoanTypeId(loanTypeId);
    return loanTypeRepo.save(c);
  }

  public void deleteById(long loanTypeId){
      loanTypeRepo.deleteById(loanTypeId);
  }
}
