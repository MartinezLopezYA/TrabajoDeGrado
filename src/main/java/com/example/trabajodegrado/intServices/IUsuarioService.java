package com.example.trabajodegrado.intServices;

import com.example.trabajodegrado.models.Usuario;

import java.util.*;

public interface IUsuarioService {

    public List<Usuario> getUsuarios();
    Optional<Usuario> editarUsuario(int idUsuario);
    public void guardarUsuario(Usuario user);
    public void eliminarUsuario(int idUsuario);


}
