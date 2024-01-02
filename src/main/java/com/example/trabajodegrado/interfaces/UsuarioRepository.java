package com.example.trabajodegrado.interfaces;

import com.example.trabajodegrado.models.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    // Page<Usuario> findByIdUsuario(Pageable page, Integer idUsuario);
    Page<Usuario> findBySemestre(Pageable page, Integer semestre);


    public Usuario findByIdUsuario(int idUsuario);
    public Usuario findByNombreUsuario(String nombreUsuario);
    public Usuario findByApellidoUsuario(String apellidoUsuario);
    public Usuario findByCorreoUsuario(String correo);
    public Usuario findBySemestre(int semestre);

    
}
