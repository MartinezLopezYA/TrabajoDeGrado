package models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;
    @Column(name = "correo_usuario")
    private String correoUsuario;
    @Column(name = "semestre")
    private int semestre;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "foto_perfil")
    private Byte fotoPerfil;
    
}
