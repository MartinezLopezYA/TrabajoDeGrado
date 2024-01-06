package com.example.trabajodegrado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabajodegrado.models.Modulo;
import com.example.trabajodegrado.services.ModuloService;

@RestController
@RequestMapping("modulo")
@CrossOrigin(origins = "http://localhost:4200")
public class ModuloController {
    
    private ModuloService moduloService;

    @Autowired
    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @GetMapping("/listamodulos")
    public Page<Modulo> getModulos(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, 
            @RequestParam(name = "orderBy", required = false, defaultValue = "idModulo") String orderBy,
            @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {
            
                Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);    
                PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort); 

        return moduloService.getModulos(pageRequest);
    }

    @PostMapping("/registrarmodulo/{idModulo}/{nombreModulo}")
    public String saveModulo(
            @PathVariable String idModulo,
            @PathVariable String nombreModulo,
            @RequestBody Modulo newModulo) {
        return moduloService.saveModulo(newModulo, idModulo, nombreModulo);
    }

    @PutMapping("/editarmodulo/{idModulo}")
    public String updateModulo(
            @PathVariable String idModulo,
            @RequestBody Modulo newModulo) {
        return moduloService.updateModulo(idModulo, newModulo);
    }

    @DeleteMapping("/eliminarmodulo")
    public String deleteModulo(
            @RequestParam(name = "idModulo") String idModulo) {
        return moduloService.deleteModulo(idModulo);
    }

}
