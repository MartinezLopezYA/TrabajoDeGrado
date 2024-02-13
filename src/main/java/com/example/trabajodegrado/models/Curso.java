package com.example.trabajodegrado.models;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {
    
    @Id
    @Column(name = "id_cursos", length = 15)
    private String idCurso;
    @Column(name = "nombre_curso", length = 50)
    private String nombreCurso;
    @Column(name = "descripcion_curso", length = 200)
    private String descripcionCurso;
    
    @OneToMany(mappedBy = "curso")
    List<Insignia> insignia;

    @OneToMany(mappedBy = "curso")
    List<Modulo> modulo;    

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estado_cursos")
    private EstadoCurso estadoCurso;

    public Curso() {
    }

    public Curso(String idCurso, String nombreCurso, String descripcionCurso) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.descripcionCurso = descripcionCurso;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    @Override
    public String toString() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("idCurso", idCurso);
            jsonNode.put("nombreCurso", nombreCurso);
            jsonNode.put("descripcionCurso", descripcionCurso);

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; 
        }
        
    }

}
