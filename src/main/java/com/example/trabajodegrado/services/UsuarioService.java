package com.example.trabajodegrado.services;

import utils.exceptions.UsuarioException;
import com.example.trabajodegrado.interfaces.UsuarioRepository;
import com.example.trabajodegrado.models.Usuario;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private static final String correoValid = "^[a-zA-Z0-9._%+-]+@uniminuto\\.edu\\.co$";
    private static final Pattern pattern = Pattern.compile(correoValid);

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @SuppressWarnings("null")
    public Page<Usuario> getUsuarios(PageRequest pageRequest) {
        return usuarioRepository.findAll(pageRequest);
    }

    public Page<Usuario> getByIdUsuario(PageRequest pageRequest, int idUsuario) {

        Page<Usuario> existUsuarioById = usuarioRepository.findByIdUsuario(pageRequest, idUsuario);
        if (existUsuarioById != null) {
            return existUsuarioById;
        } else {
            throw new UsuarioException("No Existe un Usuario con el ID: " + idUsuario);
        }

    }

    public Page<Usuario> getBySemestre(PageRequest pageRequest, int semestre) {

        Page<Usuario> result = usuarioRepository.findBySemestre(pageRequest, semestre);

        if (result != null) {
            return result;
        } else {
            throw new UsuarioException("No Existe un Usuario que este cursando : " + semestre + " semestre");
        }

    }

    @SuppressWarnings("null")
    public Usuario saveUsuario(Usuario newUsuario, int idUsuario, String correo) {

        Usuario existUserById = usuarioRepository.findByIdUsuario(idUsuario);
        Usuario existUserByCorreoUsuario = usuarioRepository.findByCorreoUsuario(correo);

        if (existUserById != null) {
            throw new UsuarioException("El usuario con ID " + idUsuario + " ya existe.");
        } else if (existUserByCorreoUsuario != null) {
            throw new UsuarioException("El usuario con correo " + correo + " ya existe.");
        } else if (!isValidCorreo(correo)){
            throw new UsuarioException("El correo debe terminar tener el dominio uniminuto.edu.co");
        } else {
            return usuarioRepository.save(newUsuario);
        }

    }

    private boolean isValidCorreo(String correo) {
        return pattern.matcher(correo).matches();
    }

    public Usuario updateUsuario(int idUsuario, Usuario newUsuario) {

        Usuario existUserById = usuarioRepository.findByIdUsuario(idUsuario);

        if (existUserById == null) {
            throw new UsuarioException("No se encontró ningún usuario con el ID " + idUsuario);
        } else {
            existUserById.setNombreUsuario(newUsuario.getNombreUsuario());
            existUserById.setApellidoUsuario(newUsuario.getApellidoUsuario());
            existUserById.setSemestre(newUsuario.getSemestre());
            existUserById.setFechaNacimiento(newUsuario.getFechaNacimiento());
            usuarioRepository.save(existUserById);
            return existUserById;
        }

    }

    public void deleteUsuario(int idUsuario) {

        Usuario existUserById = usuarioRepository.findByIdUsuario(idUsuario);

        if (existUserById == null) {
            throw new UsuarioException("No se encontró ningún usuario con el ID " + idUsuario);
        } else {
            usuarioRepository.delete(existUserById);
        }

    }

}
