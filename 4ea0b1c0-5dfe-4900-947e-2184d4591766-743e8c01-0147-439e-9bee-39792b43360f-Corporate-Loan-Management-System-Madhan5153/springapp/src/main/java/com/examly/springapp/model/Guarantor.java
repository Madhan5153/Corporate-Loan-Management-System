package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
@Table(name="Guarantor")
public class Guarantor {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long guarantorId;
  @Column(name="guarantorName")
  private String guarantorName;
  @Column(name="email")
  private String email;
  @Column(name="phonenumber")
  private String phoneNumber;
  @ManyToOne
  @JoinColumn(name="loan_id")
  private Loan loanId;
  
  public Guarantor() {
  }
  
  public Guarantor(String guarantorName, String email, String phoneNumber, Loan loanId) {
    this.guarantorName = guarantorName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.loanId = loanId;
  }

  public long getGuarantorId() {
    return guarantorId;
  }

  public void setGuarantorId(long guarantorId) {
    this.guarantorId = guarantorId;
  }

  public String getGuarantorName() {
    return guarantorName;
  }

  public void setGuarantorName(String guarantorName) {
    this.guarantorName = guarantorName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Loan getLoanId() {
    return loanId;
  }

  public void setLoanId(Loan loanId) {
    this.loanId = loanId;
  }
  
}
