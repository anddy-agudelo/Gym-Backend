package com.back.gym.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.back.gym.exceptions.CustomException;
import com.back.gym.models.EjercicioModel;
import com.back.gym.services.EjercicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EjercicioController {

    @Autowired
    EjercicioService ejercicioService;
    
    @PostMapping("/ejercicios")
    public ResponseEntity<Map<String, String>> guardar(@Valid @RequestBody EjercicioModel ejercicio,Errors error) {
        if(error.hasErrors()){
            throwError(error);
        }

        this.ejercicioService.guardarEjercicio(ejercicio);
        Map<String, String> response= new HashMap<>();
        response.put("mensaje","El ejercicio se agregó correctamente");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ejercicios")
    public List<EjercicioModel> traerTodos(){
        return this.ejercicioService.obtenerEjercicio();
    }

    @GetMapping("/ejercicios/{id}")
    public EjercicioModel buscarID(@PathVariable String id) {
       return this.ejercicioService.buscarPorId(id).get();
    }

    @DeleteMapping("/ejercicios/{id}")
    public ResponseEntity<Map<String, String>> eliminarPorId(@PathVariable String id) {
        Boolean existe=this.ejercicioService.existById(id); 

        Map<String, String> respuesta=new HashMap<>(); 
        if(!existe){ 
            respuesta.put("mensaje","No existe ejercicio por ese Id"); 
            return ResponseEntity.ok(respuesta); 
        }

        ejercicioService.eliminarPorId(id); 
        respuesta.put("mensaje","el ejercicio se eliminó correctamente");
        return ResponseEntity.ok(respuesta); 

    }

    @PutMapping("/ejercicios")
    public ResponseEntity<Map<String,String>> actualizar(@RequestBody EjercicioModel ejercicio, Errors error){
        if(error.hasErrors()){
            throwError(error); 
        }
        ejercicioService.guardarEjercicio(ejercicio);
        Map<String,String> respuesta=new HashMap<>();
        respuesta.put("mensaje","El ejercicio se actualizó correctamente");
        return ResponseEntity.ok(respuesta);
    }

    private void throwError(Errors error) {
        String message="";
        int index=0;
        for(ObjectError e: error.getAllErrors()){
            if(index>0){
                message += " | ";
            }
            message += String.format("Parametro: %s - Mensaje: %s", e.getObjectName(),e.getDefaultMessage());
        }
        throw new CustomException(message);
    }

}
