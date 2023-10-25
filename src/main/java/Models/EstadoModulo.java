package models;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_modulo")
public class EstadoModulo {
    @Id
    @Column(name = "id_estado_modulo")
    private String idEstadoModulo;
    @Column(name = "estado")
    private String estado;
}
