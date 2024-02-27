package com.example.trabajodegrado.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.trabajodegrado.models.EstadoCurso;

@Repository
public interface EstadoCursoRepository extends JpaRepository<EstadoCurso, String>{

    Page<EstadoCurso> findByIdEstadoCurso(Pageable page, String idEstadoCurso);
    Page<EstadoCurso> findByValorEstadoCurso(Pageable page, String valorEstadoCurso);
    public EstadoCurso findByIdEstadoCurso(String idEstadoCurso);
    public EstadoCurso findByValorEstadoCurso(String valorEstadoCurso);

}
