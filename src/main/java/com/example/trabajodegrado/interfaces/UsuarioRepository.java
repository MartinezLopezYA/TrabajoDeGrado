package com.example.trabajodegrado.interfaces;

import com.example.trabajodegrado.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByIdUsuario(int id);
}
