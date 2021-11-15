package com.back.gym.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class UsuarioModel {
    
    @Id
    private String id;
    private String username;
    private String password;
    @NotEmpty(message = "El campo nombres es obligatorio")
    private String nombres;
    private String cedula;
    private String genero;
    private String correo;
    private String telefono;
    private String direccion;
    private String fecha_nacimiento;
    private Double estatura;
    private Double peso;
    private EjercicioModel ejercicio;
    private SuscripcionModel suscripcion;
    private SedesModel sede;
    private String horario;
    private String hash;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public Double getEstatura() {
        return estatura;
    }
    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public SuscripcionModel getSuscripcion() {
        return suscripcion;
    }
    public void setSuscripcion(SuscripcionModel suscripcion) {
        this.suscripcion = suscripcion;
    }
    public SedesModel getSede() {
        return sede;
    }
    public void setSede(SedesModel sede) {
        this.sede = sede;
    }
    public EjercicioModel getEjercicio() {
        return ejercicio;
    }
    public void setEjercicio(EjercicioModel ejercicio) {
        this.ejercicio = ejercicio;
    }
    
    

}
