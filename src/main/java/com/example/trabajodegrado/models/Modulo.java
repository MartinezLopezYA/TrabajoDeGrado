package com.example.trabajodegrado.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "modulo")
public class Modulo {
    
    @Id
    @Column(name = "id_modulo", length = 15)
    private String idModulo;
    @Column(name = "nombre_modulo", length = 50)
    private String nombreModulo;

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

    public Modulo(String idModulo, String nombreModulo) {
        this.idModulo = idModulo;
        this.nombreModulo = nombreModulo;
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

    
}
