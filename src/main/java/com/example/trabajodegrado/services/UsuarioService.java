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

    public Page<Usuario> getByIdUsuario(PageRequest pageRequest, Integer idUsuario) {

        try {
            if (idUsuario == null) {
                return Page.empty();
            } else {
                Page<Usuario> result = usuarioRepository.findByIdUsuario(pageRequest, idUsuario);
                
                if (result != null && result.hasContent()) {
                    return result;
                } else {
                    return Page.empty();
                }    
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Page.empty();
        }
    }

    public Page<Usuario> getBySemestre(PageRequest pageRequest, Integer semestre) {

        try {
            if (semestre == null) {
                return Page.empty();
            } else {
                if (semestre < 0 || semestre > 10) {
                    return Page.empty();
                } else {
                    Page<Usuario> result = usuarioRepository.findBySemestre(pageRequest, semestre);

                    if (result != null && result.hasContent()) {
                        return result;
                    } else {
                        return Page.empty();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Page.empty();
        }

    }

    @SuppressWarnings("null")
    public Usuario saveUsuario(Usuario newUsuario, int idUsuario, String correo) {

        Usuario existUserById = usuarioRepository.findByIdUsuario(idUsuario);
        Usuario existUserByCorreoUsuario = usuarioRepository.findByCorreoUsuario(correo);

        try {
            if (existUserById != null) {
                throw new UsuarioException("El usuario con ID " + idUsuario + " ya existe.");
            } else if (existUserByCorreoUsuario != null) {
                throw new UsuarioException("El usuario con correo " + correo + " ya existe.");
            } else if (!isValidCorreo(correo)){
                throw new UsuarioException("El correo debe terminar tener el dominio uniminuto.edu.co");
            } else {
                return usuarioRepository.save(newUsuario);
            }
        } catch (UsuarioException e) {
            throw new UsuarioException("Error al registrar el Usuario " + e);
        }

    }

    private boolean isValidCorreo(String correo) {
        return pattern.matcher(correo).matches();
    }

    public Usuario updateUsuario(int idUsuario, Usuario newUsuario) {

        Usuario existUserById = usuarioRepository.findByIdUsuario(idUsuario);

        try {
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
        } catch (UsuarioException e) {
            throw new UsuarioException("Error al actualizar el Usuario " + e);
        }

    }

    public Usuario deleteUsuario(int idUsuario) {

        Usuario existUserById = usuarioRepository.findByIdUsuario(idUsuario);

        try {
            if (existUserById == null) {
                throw new UsuarioException("No se encontró ningún usuario con el ID " + idUsuario);
            } else {
                usuarioRepository.delete(existUserById);
                return existUserById;
            }
        } catch (UsuarioException e) {
            throw new UsuarioException("Error al eliminar el usuario " + e);
        }

    }

}
