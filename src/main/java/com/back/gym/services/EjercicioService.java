package com.back.gym.services;

import java.util.List;
import java.util.Optional;

import com.back.gym.models.EjercicioModel;
import com.back.gym.repositories.EjercicioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjercicioService {
    
    @Autowired
    EjercicioRepository ejercicioRepository;

    public void guardarEjercicio(EjercicioModel ejercicio){
        this.ejercicioRepository.save(ejercicio);
    }
    public List<EjercicioModel> obtenerEjercicio(){
        return this.ejercicioRepository.findAll();
    }

    public Boolean existById(String id){
        return this.ejercicioRepository.existsById(id);
    }

    public Optional<EjercicioModel> buscarPorId(String id){
        return this.ejercicioRepository.findById(id);
    }

    public void eliminarPorId(String id){
        this.ejercicioRepository.deleteById(id);
    }

}
