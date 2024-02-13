package com.example.trabajodegrado.interfaces;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trabajodegrado.models.Insignia;

@Repository
public interface InsigniaRepository extends JpaRepository<Insignia, Integer>{
    
    Page<Insignia> findByTituloInsignia(Pageable page, String tituloInsignia);
    Page<Insignia> findByFechaInsignia(Pageable page, Date fechaInsignia);
    Page<Insignia> findByTipoInsignia(Pageable page, String tipoInsignia);

}
