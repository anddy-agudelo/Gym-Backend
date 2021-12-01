package com.back.gym.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.back.gym.exceptions.CustomException;
import com.back.gym.models.MaquinaModel;
import com.back.gym.services.MaquinaService;

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
public class MaquinaController {
    
    @Autowired
    MaquinaService maquinaService;

    @PostMapping("/maquinas")
    public ResponseEntity<Map<String, String>> guardar(@Valid @RequestBody MaquinaModel maquina,Errors error) {
        if(error.hasErrors()){
            throwError(error);
        }

        this.maquinaService.guardarMaquina(maquina);
        Map<String, String> response= new HashMap<>();
        response.put("mensaje","La maquina se agregó correctamente");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/maquinas")
    public List<MaquinaModel> traerTodos(){
        return this.maquinaService.obtenerMaquina();
    }

    @GetMapping("/maquinas/{id}")
    public MaquinaModel buscarID(@PathVariable String id) {
       return this.maquinaService.buscarPorId(id).get();
    }

    @DeleteMapping("/maquinas/{id}")
    public ResponseEntity<Map<String, String>> eliminarPorId(@PathVariable String id) {
        Boolean existe=this.maquinaService.existById(id); 

        Map<String, String> respuesta=new HashMap<>(); 
        if(!existe){ 
            respuesta.put("mensaje","No existe maquina por ese Id"); 
            return ResponseEntity.ok(respuesta); 
        }

        maquinaService.eliminarPorId(id); 
        respuesta.put("mensaje","la maquina se eliminó correctamente");
        return ResponseEntity.ok(respuesta); 

    }

    @PutMapping("/maquinas")
    public ResponseEntity<Map<String,String>> actualizar(@RequestBody MaquinaModel maquina, Errors error){
        if(error.hasErrors()){
            throwError(error); 
        }
        maquinaService.guardarMaquina(maquina);
        Map<String,String> respuesta=new HashMap<>();
        respuesta.put("mensaje","La maquina se actualizó correctamente");
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
