package com.back.gym.services;

import java.util.List;
import java.util.Optional;

import com.back.gym.models.SuscripcionModel;
import com.back.gym.repositories.SuscripcionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionService {
    
    @Autowired
    SuscripcionRepository suscripcionRepository;

    public void guardarSuscripcion(SuscripcionModel suscripcion){
        this.suscripcionRepository.save(suscripcion);
   }

   public List<SuscripcionModel> obtenerSuscripcion(){
       return this.suscripcionRepository.findAll();
   }

   public Boolean existById(String id){
       return this.suscripcionRepository.existsById(id);
   }

   public Optional<SuscripcionModel> buscarPorId(String id){
       return this.suscripcionRepository.findById(id);
   }

   public void eliminarPorId(String id){
       this.suscripcionRepository.deleteById(id);
   }


}
