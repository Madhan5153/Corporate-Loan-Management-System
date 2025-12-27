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

import com.examly.springapp.model.LoanType;
import com.examly.springapp.service.LoanTypeService;

@RestController
@RequestMapping("/api/loantypes")
public class LoanTypeController {
    
  @Autowired
  private LoanTypeService service;

  @PostMapping
  public ResponseEntity<LoanType> createLoanType(@RequestBody LoanType loanType){
    return new ResponseEntity<>(service.storeLoanType(loanType),HttpStatus.CREATED);
  }

  @GetMapping("/{loanTypeId}")
  public ResponseEntity<LoanType> getLoanTypeById(@PathVariable long loanTypeId){
    Optional<LoanType> loanType = service.getLoanTypeById(loanTypeId);
    return loanType.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<LoanType>> getAllLoanTypes(){
    List<LoanType> loanType=service.getAllLoanTypes();
    return new ResponseEntity<>(loanType,HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<LoanType> updateLoanType(@PathVariable long id,@RequestBody LoanType LoanType){
    LoanType upLoanType=service.updatLoanType(id, LoanType);
    return new ResponseEntity<>(upLoanType,HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLoanType(@PathVariable long id){
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
