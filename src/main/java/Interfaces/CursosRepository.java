package Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Models.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, String>{
    
}
