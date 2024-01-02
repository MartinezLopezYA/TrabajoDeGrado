package com.example.trabajodegrado.controllers;

import com.example.trabajodegrado.models.Usuario;
import com.example.trabajodegrado.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

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

    @GetMapping("/getByIdUsuario/{idUsuario}")
    public String getByIdUsuario(
            @PathVariable Integer idUsuario) {
        return usuarioService.getByIdUsuario(idUsuario);
    }

    @GetMapping("/getBySemestre/{semestre}")
    public Page<Usuario> getBySemestre(
        @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
        @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, 
        @RequestParam(name = "orderBy", required = false, defaultValue = "idUsuario") String orderBy,
        @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction,
        @PathVariable Integer semestre) {

            Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);    
            PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);

        return usuarioService.getBySemestre(pageRequest, semestre);
    }

    @PostMapping("/registrarusuario/{idUsuario}/{correo}")
    public String saveUsuario(
            @PathVariable int idUsuario,
            @PathVariable String correo,
            @RequestBody Usuario newUsuario) {
        return usuarioService.saveUsuario(newUsuario, idUsuario, correo);
    }

    @PutMapping("/editarusuario/{idUsuario}")
    public String updateUsuario(
            @PathVariable int idUsuario,
            @RequestBody Usuario newUsuario) {
        return usuarioService.updateUsuario(idUsuario, newUsuario);
    }

    @DeleteMapping("/eliminarusuario")
    public String deleteUsuario(
            @RequestParam(name = "idUsuario") int idUsuario) {
        return usuarioService.deleteUsuario(idUsuario);
    }

}
