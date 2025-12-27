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

import com.examly.springapp.model.Loan;
import com.examly.springapp.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    
  @Autowired
  private LoanService service;

  @PostMapping
  public ResponseEntity<Loan> createLoan(@RequestBody Loan loan){
    return new ResponseEntity<>(service.storeLoan(loan),HttpStatus.CREATED);
  }

  @GetMapping("/{loanId}")
  public ResponseEntity<Loan> getLoanById(@PathVariable long loanId){
    Optional<Loan> loan = service.getLoanById(loanId);
    return loan.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<Loan>> getAllLoans(){
    List<Loan> loan=service.getAllLoans();
    return new ResponseEntity<>(loan,HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Loan> updateLoan(@PathVariable long id,@RequestBody Loan Loan){
    Loan upLoan=service.updatLoan(id, Loan);
    return new ResponseEntity<>(upLoan,HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLoan(@PathVariable long id){
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<?> getLoansByStatus(@PathVariable String status){
    try{
      List<Loan> loan = service.getLoansByStatus(status);
      if(loan.isEmpty()){
        return ResponseEntity.status(204).body("No loans found with status: "+status);
      }
      return ResponseEntity.status(200).body(loan);
    }catch(Exception e){
      return ResponseEntity.status(404).build();
    }
  }
}
