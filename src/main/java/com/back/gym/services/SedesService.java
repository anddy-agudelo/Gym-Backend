package com.back.gym.services;

import java.util.List;
import java.util.Optional;

import com.back.gym.models.SedesModel;
import com.back.gym.repositories.SedesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SedesService {
    
    @Autowired
    SedesRepository sedesRepository;

    public void guardarSedes(SedesModel sedes){
        this.sedesRepository.save(sedes);
   }

   public List<SedesModel> obtenerSedes(){
       return this.sedesRepository.findAll();
   }

   public Boolean existById(String id){
       return this.sedesRepository.existsById(id);
   }

   public Optional<SedesModel> buscarPorId(String id){
       return this.sedesRepository.findById(id);
   }

   public void eliminarPorId(String id){
       this.sedesRepository.deleteById(id);
   }

}
