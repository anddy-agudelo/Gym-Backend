package com.back.gym.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ejercicio")
public class EjercicioModel {
    
    @Id
    private String id;
    private String descripcion;
    private Boolean lunes;
    private Boolean martes;
    private Boolean miercoles;
    private Boolean jueves;
    private Boolean viernes;
    private Boolean sabado;
    private Boolean domingo;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Boolean getLunes() {
        return lunes;
    }
    public void setLunes(Boolean lunes) {
        this.lunes = lunes;
    }
    public Boolean getMartes() {
        return martes;
    }
    public void setMartes(Boolean martes) {
        this.martes = martes;
    }
    public Boolean getMiercoles() {
        return miercoles;
    }
    public void setMiercoles(Boolean miercoles) {
        this.miercoles = miercoles;
    }
    public Boolean getJueves() {
        return jueves;
    }
    public void setJueves(Boolean jueves) {
        this.jueves = jueves;
    }
    public Boolean getViernes() {
        return viernes;
    }
    public void setViernes(Boolean viernes) {
        this.viernes = viernes;
    }
    public Boolean getSabado() {
        return sabado;
    }
    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }
    public Boolean getDomingo() {
        return domingo;
    }
    public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
    }
    


}
