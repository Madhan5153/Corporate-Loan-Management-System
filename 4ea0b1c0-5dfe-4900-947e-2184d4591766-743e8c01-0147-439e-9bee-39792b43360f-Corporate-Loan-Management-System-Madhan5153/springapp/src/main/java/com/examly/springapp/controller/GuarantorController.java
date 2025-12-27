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

import com.examly.springapp.model.Guarantor;
import com.examly.springapp.service.GuarantorService;

@RestController
@RequestMapping("/api/Guarantors")
public class GuarantorController {
    
  @Autowired
  private GuarantorService service;

  @PostMapping
  public ResponseEntity<Guarantor> createGuarantor(@RequestBody Guarantor Guarantor){
    return new ResponseEntity<>(service.storeGuarantor(Guarantor),HttpStatus.CREATED);
  }

  @GetMapping("/{GuarantorId}")
  public ResponseEntity<Guarantor> getGuarantorById(@PathVariable long GuarantorId){
    Optional<Guarantor> Guarantor = service.getGuarantorById(GuarantorId);
    return Guarantor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<Guarantor>> getAllGuarantors(){
    List<Guarantor> Guarantor=service.getAllGuarantors();
    return new ResponseEntity<>(Guarantor,HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Guarantor> updateGuarantor(@PathVariable long id,@RequestBody Guarantor Guarantor){
    Guarantor upGuarantor=service.updatGuarantor(id, Guarantor);
    return new ResponseEntity<>(upGuarantor,HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteGuarantor(@PathVariable long id){
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
