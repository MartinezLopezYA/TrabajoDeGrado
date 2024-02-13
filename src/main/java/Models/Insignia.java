package Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "insignia")
public class Insignia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insignia")
    private int idInsignia;
    @Column(name = "fecha_insignia")
    private Date fechaInsignia;
}
