package com.example.trabajodegrado.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_modulo")
public class EstadoModulo {
    
    @Id
    @Column(name = "id_estado_modulo", length = 15)
    private String idEstadoModulo;
    @Column(name = "valor_estado_modulo", length = 20)
    private String valorEstadoModulo;
    
    public EstadoModulo() {
    }

    public EstadoModulo(String idEstadoModulo, String valorEstadoModulo) {
        this.idEstadoModulo = idEstadoModulo;
        this.valorEstadoModulo = valorEstadoModulo;
    }

    public String getIdEstadoModulo() {
        return idEstadoModulo;
    }

    public void setIdEstadoModulo(String idEstadoModulo) {
        this.idEstadoModulo = idEstadoModulo;
    }

    public String getValorEstadoModulo() {
        return valorEstadoModulo;
    }

    public void setValorEstadoModulo(String valorEstadoModulo) {
        this.valorEstadoModulo = valorEstadoModulo;
    }
    
}