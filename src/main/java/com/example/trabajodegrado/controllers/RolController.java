package com.example.trabajodegrado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.trabajodegrado.models.Rol;
import com.example.trabajodegrado.services.RolService;
import utils.exceptions.RolException;

@RestController
@RequestMapping("roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @SuppressWarnings("null")
    @GetMapping("/listaroles")
    public Page<Rol> getRoles(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(name = "orderBy", required = false, defaultValue = "idRol") String orderBy,
            @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {

        Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);

        return rolService.getRoles(pageRequest);
    }

    @PostMapping("/registrarrol")
    public ResponseEntity<?> saveRol(
            @RequestParam(name = "idRol") String idRol,
            @RequestParam(name = "nombreRol") String nombreRol,
            @RequestBody Rol newRol) {
        try {
            Rol saveRol = rolService.saveRol(newRol, idRol, nombreRol);
            new ResponseEntity<>(saveRol, HttpStatus.CREATED);
            return ResponseEntity.ok("Rol registrado con éxito");
        } catch (RolException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarrol")
    public ResponseEntity<?> deleteRol(
            @RequestParam(name = "idRol") String idRol) {
        try {
            rolService.deleteRol(idRol);
            return ResponseEntity.ok("Rol eliminado" );
        } catch (RolException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
