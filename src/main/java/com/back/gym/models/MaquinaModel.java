package com.back.gym.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="maquina")
public class MaquinaModel {
    
    @Id
    private String id;
    private String nombre_maq;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre_maq() {
        return nombre_maq;
    }
    public void setNombre_maq(String nombre_maq) {
        this.nombre_maq = nombre_maq;
    }
    
}
