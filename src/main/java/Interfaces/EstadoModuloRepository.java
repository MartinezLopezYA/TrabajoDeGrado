package interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.EstadoModulo;

@Repository
public interface EstadoModuloRepository extends JpaRepository<EstadoModulo, String>{
    
}
