package com.examly.springapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{
  @Query("select p from Customer p where p.email= :email")
  Optional<Customer> findByEmail(@Param("email") String email);

  @Query("select p from Customer p where p.creditScore >= :creditScore")
  List<Customer> findByCreditScoreGreaterThanEqual(@Param("creditScore")double creditScore);
}
 

