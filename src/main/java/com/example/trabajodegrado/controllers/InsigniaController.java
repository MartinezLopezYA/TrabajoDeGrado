package com.example.trabajodegrado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.example.trabajodegrado.models.Insignia;
import com.example.trabajodegrado.services.InsigniaService;

import utils.exceptions.InsigniaException;

@RestController
@RequestMapping("insignia")
@CrossOrigin(origins = "http://localhost:4200")
public class InsigniaController {
    
    private InsigniaService insigniaService;

    @Autowired
    public InsigniaController(InsigniaService insigniaService) {
        this.insigniaService = insigniaService;
    }

    @SuppressWarnings("null")
    @GetMapping("/listainsignias")
    public Page<Insignia> getInsignias(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, 
            @RequestParam(name = "orderBy", required = false, defaultValue = "idInsignia") String orderBy,
            @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {
            
                Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);    
                PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort); 

        return insigniaService.getInsignias(pageRequest);
    }

    @SuppressWarnings("null")
    @GetMapping("/getByTituloInsignia/{tituloInsignia}")
    public Page<Insignia> getByTituloInsignia(
        @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
        @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, 
        @RequestParam(name = "orderBy", required = false, defaultValue = "idUsuario") String orderBy,
        @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction,
        @PathVariable String tituloInsignia) {

            Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);    
            PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);

        return insigniaService.getByTituloInsignia(pageRequest, tituloInsignia);
    }

    @PostMapping("/registrarinsignia/{idInsignia}")
    public ResponseEntity<?> saveInsignia(
            @PathVariable int idInsignia,
            @RequestBody Insignia newInsignia) {
        try {
            Insignia saveInsignia = insigniaService.saveInsignia(newInsignia, idInsignia);
            return new ResponseEntity<>(saveInsignia, HttpStatus.CREATED);
        } catch (InsigniaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/editarinsignia/{idInsignia}")
    public ResponseEntity<?> updateInsignia(
            @PathVariable int idInsignia,
            @RequestBody Insignia newInsignia) {
        try {
            Insignia updatedInsignia = insigniaService.updateInsignia(idInsignia, newInsignia);
            return new ResponseEntity<>(updatedInsignia, HttpStatus.OK);
        } catch (InsigniaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarinsignia")
    public ResponseEntity<?> deleteInsignia(
            @RequestParam(name = "idInsignia") int idInsignia) {
        try {
            insigniaService.deleteInsignia(idInsignia);
            return ResponseEntity.ok("Insignia Eliminada");
        } catch (InsigniaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
