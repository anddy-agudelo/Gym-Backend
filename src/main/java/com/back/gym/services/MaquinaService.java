package com.back.gym.services;

import java.util.List;
import java.util.Optional;

import com.back.gym.models.MaquinaModel;
import com.back.gym.repositories.MaquinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaquinaService {

    @Autowired
    MaquinaRepository maquinaRepository;

    public void guardarMaquina(MaquinaModel maquina){
        this.maquinaRepository.save(maquina);
   }

   public List<MaquinaModel> obtenerMaquina(){
       return this.maquinaRepository.findAll();
   }

   public Boolean existById(String id){
       return this.maquinaRepository.existsById(id);
   }

   public Optional<MaquinaModel> buscarPorId(String id){
       return this.maquinaRepository.findById(id);
   }

   public void eliminarPorId(String id){
       this.maquinaRepository.deleteById(id);
   }
}
