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

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Page<Usuario> getUsuarios(PageRequest pageRequest) {
        return usuarioRepository.findAll(pageRequest);
    }

    public String getByIdUsuario(Integer idUsuario) {

        Usuario result = usuarioRepository.findByIdUsuario(idUsuario);

        try {
            if (idUsuario == null) {
                return "Digite un ID";
            } else {
                if (result != null) {
                    return "" + result;
                } else {
                    return "No existe ningún estudiante con ese ID";
                }
            }
        } catch (Exception e) {
            return "Error al encontrar Usuario " + e;
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

    public String saveUsuario(Usuario newUsuario, int idUsuario, String correo) {

        Optional<Usuario> existById = usuarioRepository.findById(idUsuario);
        Usuario existByCorreo = usuarioRepository.findByCorreoUsuario(correo);

        try {
            if (usuarioRepository.existsById(idUsuario)) {
                return "Ya existe el usuario con este Id: " + existById.toString();
            } else if (existByCorreo.equals(existByCorreo)) {
                return "Ya existe el usuario con el Correo: " + existByCorreo.getCorreoUsuario();
            } else {
                usuarioRepository.save(newUsuario);
                return "Usuario registrado con exito";
            }
        } catch (Exception e) {
            return "Error al registrar el usuario " + e;
        }

    }

    public String updateUsuario(int idUsuario, Usuario newUsuario) {

        Optional<Usuario> existUsuario = usuarioRepository.findById(idUsuario);

        try {
            if (existUsuario.isPresent()) {

                Usuario exist = existUsuario.get();

                exist.setNombreUsuario(newUsuario.getNombreUsuario());
                exist.setApellidoUsuario(newUsuario.getApellidoUsuario());
                exist.setSemestre(newUsuario.getSemestre());
                exist.setFechaNacimiento(newUsuario.getFechaNacimiento());

                usuarioRepository.save(exist);

                return "Usuario actualizado con exito: \n" + exist.toString();

            } else {
                return "No existe ningún usuario con este Id";
            }
        } catch (Exception e) {
            return "Error al actualizar el usuario";
        }

    }

    public String deleteUsuario(int idUsuario) {

        try {
            Usuario usuario = usuarioRepository.findById(idUsuario).get();
            usuarioRepository.delete(usuario);
            return "Registro eliminado de la tabla Usuario";
        } catch (Exception e) {
            return "No se pudo completar la ejecución de la tabla Usuario" + e;
        }

    }

}
