package com.example.trabajodegrado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabajodegrado.models.Rol;
import com.example.trabajodegrado.services.RolService;

@RestController
@RequestMapping("roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {
    
    private RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/listaroles")
    public String getRoles(){
        return rolService.getRoles();
    }

    @PostMapping("/registrarrol/{idRol}/{nombreRol}")
    public String saveRol(
            @PathVariable String idRol,
            @PathVariable String nombreRol,
            @RequestBody Rol newRol) {
        return rolService.saveRol(newRol, idRol, nombreRol);
    }
}
