package com.example.trabajodegrado.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.persistence.*;

@Entity
@Table(name = "insignia")
public class Insignia {
    
    @Id
    @Column(name = "id_insginia")
    private int idInsignia;
    @Column(name = "titulo_insignia")
    private String tituloInsignia;
    @Temporal(TemporalType.DATE)
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

    public Insignia(int idInsignia, String tituloInsignia,Date fechaInsignia, String tipoInsignia) {
        this.idInsignia = idInsignia;
        this.tituloInsignia = tituloInsignia;
        this.fechaInsignia = fechaInsignia;
        this.tipoInsignia = tipoInsignia;
    }

    public int getIdInsignia() {
        return idInsignia;
    }

    public void setIdInsignia(int idInsignia) {
        this.idInsignia = idInsignia;
    }

    public String getTituloInsignia() {
        return tituloInsignia;
    }

    public void setTituloInsignia(String tituloInsignia) {
        this.tituloInsignia = tituloInsignia;
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

    @Override
    public String toString() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("idInsignia", idInsignia);
            jsonNode.put("tituloInsignia", tituloInsignia);
            jsonNode.put("fechaInsignia", fechaInsignia.toString());
            jsonNode.put("tipoInsignia", tipoInsignia);


            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; 
        }
        
    }

}
