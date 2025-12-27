package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long customerId;
  @Column(name="customerName")
  private String customerName;
  @Column(name="email")
  private String email;
  @Column(name="phone")
  private String phone;
  @Column(name="address")
  private String address;
  private double creditScore;
  
  public Customer() {
  }

  public Customer(long customerId,String customerName, String email, String phone, String address,double creditScore) {
    this.customerId = customerId;
    this.customerName = customerName;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.creditScore=creditScore;
  }

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

public double getCreditScore() {
  return creditScore;
}

public void setCreditScore(double creditScore) {
  this.creditScore = creditScore;
}
  
}