package com.example.trabajodegrado.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.trabajodegrado.models.EstadoModulo;

@Repository
public interface EstadoModuloRepository extends JpaRepository<EstadoModulo, String>{

    Page<EstadoModulo> findByIdEstadoModulo(Pageable page, String idEstadoModulo);
    Page<EstadoModulo> findByValorEstadoModulo(Pageable page, String valorEstadoModulo);
    public EstadoModulo findByIdEstadoModulo(String idEstadoModulo);
    public EstadoModulo findByValorEstadoModulo(String valorEstadoModulo);

}
