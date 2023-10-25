package interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, String>{
    
}
