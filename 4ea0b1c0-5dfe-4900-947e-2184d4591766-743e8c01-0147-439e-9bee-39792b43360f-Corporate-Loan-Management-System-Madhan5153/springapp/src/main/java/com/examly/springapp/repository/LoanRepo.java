package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan,Long>{

  @Query("select l from Loan l where l.status = :status")
  List<Loan> findByStatus(@Param("status") String status);
  
}