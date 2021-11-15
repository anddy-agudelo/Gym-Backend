package com.back.gym.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="sede")
public class SedesModel {
    
    @Id
    private String id;
    private String nombre_sede;
    private String direccion;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre_sede() {
        return nombre_sede;
    }
    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

}
