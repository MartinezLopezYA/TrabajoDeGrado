package com.example.trabajodegrado.services;

import com.example.trabajodegrado.exceptions.UsuarioException;
import com.example.trabajodegrado.interfaces.UsuarioRepository;
import com.example.trabajodegrado.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

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

    public Usuario saveUsuario(Usuario newUsuario, int idUsuario, String correo) {

        Usuario existUser = usuarioRepository.findByIdUsuario(idUsuario);
        Usuario existUsuario = usuarioRepository.findByCorreoUsuario(correo);

        if (existUser != null) {
            throw new UsuarioException("El usuario con ID " + idUsuario + " ya existe.");
        } else if (existUsuario != null) {
            throw new UsuarioException("El usuario con correo " + correo + " ya existe.");
        } else {
            return usuarioRepository.save(newUsuario);
        }

    }

    public Usuario updateUsuario(int idUsuario, Usuario newUsuario) {

        Usuario existUser = usuarioRepository.findByIdUsuario(idUsuario);

        if (existUser == null) {
            throw new UsuarioException("No se encontró ningún usuario con el ID " + idUsuario);
        } else {
            existUser.setNombreUsuario(newUsuario.getNombreUsuario());
            existUser.setApellidoUsuario(newUsuario.getApellidoUsuario());
            existUser.setSemestre(newUsuario.getSemestre());
            existUser.setFechaNacimiento(newUsuario.getFechaNacimiento());
            usuarioRepository.save(existUser);
            return existUser;
        }

    }

    public Usuario deleteUsuario(int idUsuario) {

        Usuario existUser = usuarioRepository.findByIdUsuario(idUsuario);

        if (existUser == null) {
            throw new UsuarioException("No se encontró ningún usuario con el ID " + idUsuario);
        } else {
            usuarioRepository.delete(existUser);
            return existUser;
        }

    }

}
