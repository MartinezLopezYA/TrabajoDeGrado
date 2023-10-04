package Models;

import jakarta.persistence.*;

@Entity
@Table(name = "modulo")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private int idModulo;
    @Column(name = "nombre_modulo")
    private String nombreModulo;
}
