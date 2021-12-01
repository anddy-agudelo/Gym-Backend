package com.back.gym.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.back.gym.exceptions.CustomException;
import com.back.gym.models.SuscripcionModel;
import com.back.gym.services.SuscripcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class SuscripcionController {
    
    @Autowired
    SuscripcionService suscripcionService;


    @PostMapping("/suscripciones")
    public ResponseEntity<Map<String, String>> guardar(@Valid @RequestBody SuscripcionModel suscripciones,Errors error) {
        if(error.hasErrors()){
            throwError(error);
        }

        this.suscripcionService.guardarSuscripcion(suscripciones);
        Map<String, String> response= new HashMap<>();
        response.put("mensaje","La suscripción se agregó correctamente");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/suscripciones")
    public List<SuscripcionModel> traerTodos(){
        return this.suscripcionService.obtenerSuscripcion();
    }

    @GetMapping("/suscripciones/{id}")
    public SuscripcionModel buscarID(@PathVariable String id) {
       return this.suscripcionService.buscarPorId(id).get();
    }

    @DeleteMapping("/suscripciones/{id}")
    public ResponseEntity<Map<String, String>> eliminarPorId(@PathVariable String id) {
        Boolean existe=this.suscripcionService.existById(id); 

        Map<String, String> respuesta=new HashMap<>(); 
        if(!existe){ 
            respuesta.put("mensaje","No existe suscripción por ese Id"); 
            return ResponseEntity.ok(respuesta); 
        }

        suscripcionService.eliminarPorId(id); 
        respuesta.put("mensaje","La suscripción se eliminó correctamente");
        return ResponseEntity.ok(respuesta); 

    }

    @PutMapping("/suscripciones")
    public ResponseEntity<Map<String,String>> actualizar(@RequestBody SuscripcionModel suscripciones, Errors error){
        if(error.hasErrors()){
            throwError(error); 
        }
        suscripcionService.guardarSuscripcion(suscripciones);
        Map<String,String> respuesta=new HashMap<>();
        respuesta.put("mensaje","La suscripción se actualizó correctamente");
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
