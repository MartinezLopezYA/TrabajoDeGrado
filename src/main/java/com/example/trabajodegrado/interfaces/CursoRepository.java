package com.example.trabajodegrado.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.lang.String;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.trabajodegrado.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String>{

    Page<Curso> findByIdCurso(Pageable page, String idCurso);
    Page<Curso> findByNombreCurso(Pageable page, String nombreCurso);
    public Curso findByIdCurso(String idCurso);
    public Curso findByNombreCurso(String nombreCurso);

}
