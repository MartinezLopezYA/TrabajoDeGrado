package com.example.trabajodegrado.models;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.persistence.*;

@Entity
@Table(name = "modulo")
public class Modulo {
    
    @Id
    @Column(name = "id_modulo", length = 15)
    private String idModulo;
    @Column(name = "nombre_modulo", length = 50)
    private String nombreModulo;
    @Column(name = "descripcion_modulo", length = 200)
    private String descripcionModulo;

    @OneToMany(mappedBy = "modulo")
    List<Insignia> insignia;

    @ManyToOne
    @JoinColumn(name = "id_estado_modulo")
    private EstadoModulo estadoModulo;

    @ManyToOne
    @JoinColumn(name = "id_cursos")
    private Curso curso;    

    public Modulo() {
    }

    public Modulo(String idModulo, String nombreModulo, String descripcionModulo) {
        this.idModulo = idModulo;
        this.nombreModulo = nombreModulo;
        this.descripcionModulo = descripcionModulo;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getDescripcionModulo() {
        return descripcionModulo;
    }

    public void setDescripcionModulo(String descripcionModulo) {
        this.descripcionModulo = descripcionModulo;
    }

    @Override
    public String toString() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("idModulo", idModulo);
            jsonNode.put("nombreModulo", nombreModulo);
            jsonNode.put("descripcionModulo", descripcionModulo);

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; 
        }
        
    }
    
}
