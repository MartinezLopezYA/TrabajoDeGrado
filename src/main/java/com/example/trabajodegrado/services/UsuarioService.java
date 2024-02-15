package com.example.trabajodegrado.services;

import com.example.trabajodegrado.interfaces.UsuarioRepository;
import com.example.trabajodegrado.models.Usuario;

import java.util.Optional;

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

        try {

            if (existUser != null) {
                return existUser;
            } else if (existUsuario != null) {
                return existUsuario;
            } else {
                return usuarioRepository.save(newUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Usuario updateUsuario(int idUsuario, Usuario newUsuario) {

        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

        if (usuario.isPresent()) {
            Usuario exist = usuario.get();
            exist.setNombreUsuario(newUsuario.getNombreUsuario());
            exist.setApellidoUsuario(newUsuario.getApellidoUsuario());
            exist.setSemestre(newUsuario.getSemestre());
            exist.setFechaNacimiento(newUsuario.getFechaNacimiento());

            try {
                return usuarioRepository.save(exist);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }

    }

    public Usuario deleteUsuario(int idUsuario) {

        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
        } else {
            throw new RuntimeException("No se encontró ningún usuario con el ID proporcionado");
        }

        return null;
    }

}
