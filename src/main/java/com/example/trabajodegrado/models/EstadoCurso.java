package com.example.trabajodegrado.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_cursos")
public class EstadoCurso {
    
    @Id
    @Column(name = "id_estado_cursos", length = 15)
    private String idEstadoCurso;
    @Column(name = "valor_estado_cursos", length = 20)
    private String valorEstadoCurso;
    
    public EstadoCurso() {
    }

    public EstadoCurso(String idEstadoCurso, String valorEstadoCurso) {
        this.idEstadoCurso = idEstadoCurso;
        this.valorEstadoCurso = valorEstadoCurso;
    }

    public String getIdEstadoCurso() {
        return idEstadoCurso;
    }

    public void setIdEstadoCurso(String idEstadoCurso) {
        this.idEstadoCurso = idEstadoCurso;
    }

    public String getValorEstadoCurso() {
        return valorEstadoCurso;
    }

    public void setValorEstadoCurso(String valorEstadoCurso) {
        this.valorEstadoCurso = valorEstadoCurso;
    }

    @Override
    public String toString() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("idEstadoCurso", idEstadoCurso);
            jsonNode.put("valorEstadoCurso", valorEstadoCurso);

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; 
        }
        
    }

}
