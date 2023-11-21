package com.example.trabajodegrado.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Cursos {
    @Id
    @Column(name = "id_cursos")
    private String idCurso;
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @Column(name = "descripcion_curso")
    private String descripcionCurso;
}
