package com.example.trabajodegrado.controllers;

import utils.exceptions.UsuarioException;
import com.example.trabajodegrado.models.Usuario;
import com.example.trabajodegrado.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @SuppressWarnings("null")
    @GetMapping("/listausuarios")
    public Page<Usuario> getUsuarios(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, 
            @RequestParam(name = "orderBy", required = false, defaultValue = "idUsuario") String orderBy,
            @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {
            
                Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);    
                PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort); 

        return usuarioService.getUsuarios(pageRequest);
    }

    @GetMapping("/getByIdUsuario")
    public Page<Usuario> getByIdUsuario(
        @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
        @RequestParam(name = "pageSize", required = false, defaultValue = "1") int pageSize,
        @RequestParam(name = "idUsuario") int idUsuario) {

            PageRequest pageRequest = PageRequest.of(pageNo, pageSize);

        return usuarioService.getByIdUsuario(pageRequest, idUsuario);
    }

    @SuppressWarnings("null")
    @GetMapping("/getBySemestre")
    public Page<Usuario> getBySemestre(
        @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
        @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, 
        @RequestParam(name = "orderBy", required = false, defaultValue = "idUsuario") String orderBy,
        @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction,
        @RequestParam(name = "semestre") int semestre) {

            Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);    
            PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);

        return usuarioService.getBySemestre(pageRequest, semestre);
    }

    @PostMapping("/registrarusuario")
    public ResponseEntity<?> saveUsuario(
            @RequestParam(name = "idUsuario") int idUsuario,
            @RequestParam(name = "correo") String correo,
            @RequestBody Usuario newUsuario) {
        try {
            Usuario saveUsuario = usuarioService.saveUsuario(newUsuario, idUsuario, correo);
            new ResponseEntity<>(saveUsuario, HttpStatus.CREATED);
            return ResponseEntity.ok("Usuario Registrado con éxito");
        } catch (UsuarioException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/editarusuario")
    public ResponseEntity<?> updateUsuario(
            @RequestParam(name = "idUsuario") int idUsuario,
            @RequestBody Usuario newUsuario) {
        try {
            Usuario updateUsuario = usuarioService.updateUsuario(idUsuario, newUsuario);
            new ResponseEntity<>(updateUsuario, HttpStatus.OK);
            return ResponseEntity.ok("Usuario Actualizado con éxito");
        } catch (UsuarioException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarusuario")
    public ResponseEntity<?> deleteUsuario(
            @RequestParam(name = "idUsuario") int idUsuario) {
        try {
            usuarioService.deleteUsuario(idUsuario);
            return ResponseEntity.ok("Usuario eliminado" );
        } catch (UsuarioException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
