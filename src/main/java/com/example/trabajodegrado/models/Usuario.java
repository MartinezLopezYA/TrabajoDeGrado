package com.example.trabajodegrado.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    public static final String JSON = null;
    @Id
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(name = "nombre_usuario", length = 50)
    private String nombreUsuario;
    @Column(name = "apellido_usuario", length = 50)
    private String apellidoUsuario;
    @Column(name = "correo_usuario", length = 100)
    private String correoUsuario;
    @Column(name = "semestre", length = 11)
    private int semestre;
    @Column(name = "contrasena", length = 30)
    private String contrasena;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    private Date fechaNacimiento;
    @Column(name = "foto_perfil")
    private Byte fotoPerfil;

    @OneToMany(mappedBy ="usuario")
    List<Insignia> insignia;

    @OneToMany(mappedBy ="usuario")
    List<Curso> curso;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario, int semestre, String contrasena, Date fechaNacimiento, Byte fotoPerfil) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.semestre = semestre;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.fotoPerfil = fotoPerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Byte getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(Byte fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public String toString() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("idUsuario", idUsuario);
            jsonNode.put("nombreUsuario", nombreUsuario);
            jsonNode.put("apellidoUsuario", apellidoUsuario);
            jsonNode.put("correoUsuario", correoUsuario);
            jsonNode.put("semestre", semestre);
            jsonNode.put("fechaNacimiento", fechaNacimiento.toString());

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; 
        }
        
    }
    
}
