package com.back.gym.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suscripcion")
public class SuscripcionModel {
    
    @Id
    private String id;
    private String tipo_suscrip;
    private String costo;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTipo_suscrip() {
        return tipo_suscrip;
    }
    public void setTipo_suscrip(String tipo_suscrip) {
        this.tipo_suscrip = tipo_suscrip;
    }
    public String getCosto() {
        return costo;
    }
    public void setCosto(String costo) {
        this.costo = costo;
    }

}
