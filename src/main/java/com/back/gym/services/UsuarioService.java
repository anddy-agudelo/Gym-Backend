package com.back.gym.services;

import java.util.List;
import java.util.Optional;

import com.back.gym.models.UsuarioModel;
import com.back.gym.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public void guardarUsuario(UsuarioModel usuario){
        this.usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> obtenerUsuario(){
        return this.usuarioRepository.findAll();
    }

    public Boolean existById(String id){
        return this.usuarioRepository.existsById(id);
    }

    public Optional<UsuarioModel> buscarPorId(String id){
        return this.usuarioRepository.findById(id);
    }
    
    public void eliminarPorId(String id){
        this.usuarioRepository.deleteById(id);
    }
}
