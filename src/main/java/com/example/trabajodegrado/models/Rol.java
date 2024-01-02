package com.example.trabajodegrado.models;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

    @Override
    public String toString() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("idRol", idRol);
            jsonNode.put("nombreRol", nombreRol);

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; 
        }
        
    }

}
