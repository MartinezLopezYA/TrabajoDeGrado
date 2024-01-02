package com.example.trabajodegrado.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "insignia")
public class Insignia {
    
    @Id
    @Column(name = "id_insginia")
    private int idInsignia;
    @Column(name = "fecha_insignia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    private Date fechaInsignia;
    @Column(name = "tipo_insignia")
    private String tipoInsignia;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_modulo")
    private Modulo modulo;
    
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    public Insignia() {
    }

    public Insignia(int idInsignia, Date fechaInsignia, String tipoInsignia) {
        this.idInsignia = idInsignia;
        this.fechaInsignia = fechaInsignia;
        this.tipoInsignia = tipoInsignia;
    }

    public int getIdInsignia() {
        return idInsignia;
    }

    public void setIdInsignia(int idInsignia) {
        this.idInsignia = idInsignia;
    }

    public Date getFechaInsignia() {
        return fechaInsignia;
    }

    public void setFechaInsignia(Date fechaInsignia) {
        this.fechaInsignia = fechaInsignia;
    }

    public String getTipoInsignia() {
        return tipoInsignia;
    }

    public void setTipoInsignia(String tipoInsignia) {
        this.tipoInsignia = tipoInsignia;
    }

}
