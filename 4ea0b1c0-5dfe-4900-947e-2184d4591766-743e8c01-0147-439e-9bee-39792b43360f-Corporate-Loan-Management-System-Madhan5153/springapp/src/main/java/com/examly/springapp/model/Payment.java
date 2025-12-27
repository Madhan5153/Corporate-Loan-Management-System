package com.examly.springapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="Payment")
public class Payment{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long paymentId;
  @Column(name="amount")
  private double amount;
  @Column(name="payment")
  private LocalDateTime paymentDate;
  @ManyToOne
  @JoinColumn(name="loan_id")
  private Loan loan;
  
  public Payment() {
  }
  public Payment(long paymentId, double amount, LocalDateTime paymentDate, Loan loan) {
    this.paymentId = paymentId;
    this.amount = amount;
    this.paymentDate = paymentDate;
    this.loan = loan;
  }
  public long getPaymentId() {
    return paymentId;
  }
  public void setPaymentId(long paymentId) {
    this.paymentId = paymentId;
  }
  public double getAmount() {
    return amount;
  }
  public void setAmount(double amount) {
    this.amount = amount;
  }
  public LocalDateTime getPaymentDate() {
    return paymentDate;
  }
  public void setPaymentDate(LocalDateTime paymentDate) {
    this.paymentDate = paymentDate;
  }
  public Loan getLoan() {
    return loan;
  }
  public void setLoan(Loan loan) {
    this.loan = loan;
  }
  
}
