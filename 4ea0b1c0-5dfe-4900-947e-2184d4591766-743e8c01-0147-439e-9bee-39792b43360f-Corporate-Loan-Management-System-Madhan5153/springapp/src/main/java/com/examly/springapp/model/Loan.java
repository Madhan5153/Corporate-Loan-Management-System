package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
@Table(name="Loan")
public class Loan{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long loanId;
  @Column(name="loanAmount")
  private double loanAmount;
  @Column(name="interestRat")
  private double interestRate;
  @Column(name="tenureMonths")
  private int tenureMonths;
  @Column(name="status")
  private String status;
  @ManyToOne
  @JoinColumn(name="customer_id")
  private Customer customer;
  @ManyToOne
  @JoinColumn(name="loan_type_id")
  private LoanType loanType;
  
  public Loan() {
  }

  public Loan(long loanId, double loanAmount, double interestRate, int tenureMonths, String status, Customer customer,
      LoanType loanType) {
    this.loanId = loanId;
    this.loanAmount = loanAmount;
    this.interestRate = interestRate;
    this.tenureMonths = tenureMonths;
    this.status = status;
    this.customer = customer;
    this.loanType = loanType;
  }

  public long getLoanId() {
    return loanId;
  }

  public void setLoanId(long loanId) {
    this.loanId = loanId;
  }

  public double getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  public int getTenureMonths() {
    return tenureMonths;
  }

  public void setTenureMonths(int tenureMonths) {
    this.tenureMonths = tenureMonths;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public LoanType getLoanType() {
    return loanType;
  }

  public void setLoanType(LoanType loanType) {
    this.loanType = loanType;
  }
  
  
}
