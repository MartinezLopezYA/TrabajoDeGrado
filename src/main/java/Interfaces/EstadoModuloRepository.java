package Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Models.EstadoModulo;

@Repository
public interface EstadoModuloRepository extends JpaRepository<EstadoModulo, String>{
    
}
