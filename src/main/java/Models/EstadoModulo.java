package Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_modulo")
public class EstadoModulo {

    @Id
    @Column(name = "id_estado_modulo")
    private String idEstadoModulo;
    @Column(name = "estado")
    private String estado;
}
