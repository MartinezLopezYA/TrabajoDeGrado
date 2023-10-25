package interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, String>{
    
}
