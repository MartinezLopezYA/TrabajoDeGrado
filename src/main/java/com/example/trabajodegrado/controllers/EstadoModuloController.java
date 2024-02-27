package com.example.trabajodegrado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabajodegrado.models.EstadoModulo;
import com.example.trabajodegrado.services.EstadoModuloService;

@RestController
@RequestMapping("estadomodulo")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoModuloController {
 
    private EstadoModuloService estadoModuloService;

    @Autowired
    public EstadoModuloController(EstadoModuloService estadoModuloService) {
        this.estadoModuloService = estadoModuloService;
    }

    @SuppressWarnings("null")
    @GetMapping("/listaestadosmodulos")
    public Page<EstadoModulo> getEstadosModulo(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, 
            @RequestParam(name = "orderBy", required = false, defaultValue = "idEstadoModulo") String orderBy,
            @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {
            
                Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);    
                PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort); 

        return estadoModuloService.getEstadosModulo(pageRequest);
    }

    @PostMapping("/registrarestadomodulo/{idEstadoModulo}")
    public String saveEstadoModulo(
            @PathVariable String idEstadoModulo,
            @RequestBody EstadoModulo newEstadoModulo) {
        return estadoModuloService.saveEstadoModulo(newEstadoModulo, idEstadoModulo);
    }

}
