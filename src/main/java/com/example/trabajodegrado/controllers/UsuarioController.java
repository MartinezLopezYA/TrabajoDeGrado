package com.example.trabajodegrado.controllers;

import com.example.trabajodegrado.intServices.IUsuarioService;
import com.example.trabajodegrado.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping("/listausuarios")
    @ResponseBody
    public List<Usuario> getUsuarios() {
        return service.getUsuarios();
    }

    @PostMapping("/registrarusuario")
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario user) {
        try {
            service.guardarUsuario(user);
            return  ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body("Usuario registrado exitosamente");
        } catch (Exception e) {
            // Manejar el error, puedes personalizar este mensaje de acuerdo a tus
            // necesidades
            return new ResponseEntity<>("Error al registrar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editarusuario/{idUsuario}")
    public ResponseEntity<String> editarUsuario(@PathVariable int idUsuario, @RequestBody Usuario user) {
        try {
            Optional<Usuario> existeUsuarioOptional = service.editarUsuario(idUsuario);
            if (existeUsuarioOptional.isPresent()) {
                Usuario existeUsuario = existeUsuarioOptional.get();
                existeUsuario.setNombreUsuario(user.getNombreUsuario());
                existeUsuario.setApellidoUsuario(user.getApellidoUsuario());
                existeUsuario.setCorreoUsuario(user.getCorreoUsuario());
                existeUsuario.setSemestre(user.getSemestre());
                service.guardarUsuario(existeUsuario);
                return new ResponseEntity<>("Usuario actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No fue posible encontrar el usuario", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminarusuario/{idUsuario}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int idUsuario) {
        try {
            Optional<Usuario> existeUsuarioOptional = service.editarUsuario(idUsuario);

            if (existeUsuarioOptional.isPresent()) {
                service.eliminarUsuario(idUsuario);
                return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No fue posible encontrar el usuario", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
