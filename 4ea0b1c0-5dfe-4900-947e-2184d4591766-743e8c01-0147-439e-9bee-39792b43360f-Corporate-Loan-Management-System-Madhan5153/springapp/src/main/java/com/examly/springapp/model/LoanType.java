package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
@Table(name="LoanType")
public class LoanType{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long loanTypeId;
  @Column(name="typeName")
  private String typeName;
  @Column(name="description")
  private String description;
  @Column(name="interestRate")
  private double interestRate;
  
  public LoanType() {
  }

  public LoanType(long loanTypeId,String typeName, String description, double interestRate) {
    this.loanTypeId = loanTypeId;
    this.typeName = typeName;
    this.description = description;
    this.interestRate = interestRate;
  }

  public long getLoanTypeId() {
    return loanTypeId;
  }

  public void setLoanTypeId(long loanTypeId) {
    this.loanTypeId = loanTypeId;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

   
}