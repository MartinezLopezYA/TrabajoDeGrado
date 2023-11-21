package com.example.trabajodegrado.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "insignia")
public class Insignia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insginia")
    private int idInsignia;
    @Column(name = "fecha_insignia")
    private Date fechaInsignia;
}
