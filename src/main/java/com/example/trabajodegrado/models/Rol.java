package com.example.trabajodegrado.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    
    @Id
    @Column(name = "id_rol", length = 15)
    private String idRol;
    @Column(name = "nombre_rol", length = 50)
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    List<Usuario> usuario;

    public Rol() {
    }

    public Rol(String idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

}
