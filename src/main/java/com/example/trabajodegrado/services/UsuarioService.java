package com.example.trabajodegrado.services;

import com.example.trabajodegrado.intServices.IUsuarioService;
import com.example.trabajodegrado.interfaces.UsuarioRepository;
import com.example.trabajodegrado.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    public UsuarioRepository data;

    @Override
    public List<Usuario>getUsuarios(){
        return data.findAll();
    }

    @Override
    public void guardarUsuario(Usuario user){
        data.save(user);
    }

    @Override
    public Optional<Usuario> editarUsuario(int idUsuario){
        return data.findById(idUsuario);
    }

    @Override
    public void eliminarUsuario(int idUsuario){
        data.deleteById(idUsuario);
    }


}
