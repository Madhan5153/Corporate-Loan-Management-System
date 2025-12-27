package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Guarantor;
import com.examly.springapp.repository.GuarantorRepo;

@Service
public class GuarantorService {
    
  @Autowired
  private GuarantorRepo guarantorRepo;
  
  public Guarantor storeGuarantor(Guarantor c){
    return guarantorRepo.save(c);
  }

  public Optional<Guarantor> getGuarantorById(long GuarantorId){
    return guarantorRepo.findById(GuarantorId);
  }

  public List<Guarantor> getAllGuarantors(){
    return guarantorRepo.findAll();
  }

  public Guarantor updatGuarantor(long GuarantorId,Guarantor c){
    c.setGuarantorId(GuarantorId);
    return guarantorRepo.save(c);
  }

  public void deleteById(long GuarantorId){
      guarantorRepo.deleteById(GuarantorId);
  }
}
