package Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(name = "nombre_usuario")
    private String nombreusuario;
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;
    @Column(name = "correo_usuario")
    private String correoUsuario;
    @Column(name = "semestre")
    private int semestre;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "fecha_nacimineto")
    private Date fechaNacimineto;
    @Column(name = "foto_perfil")
    private Byte fotoPerfil;
}
