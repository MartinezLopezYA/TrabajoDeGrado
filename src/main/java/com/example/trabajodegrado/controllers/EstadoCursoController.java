package com.example.trabajodegrado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.trabajodegrado.models.EstadoCurso;
import com.example.trabajodegrado.services.EstadoCursoService;
import utils.exceptions.EstadoCursoException;

@RestController
@RequestMapping("estadocurso")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoCursoController {
    
    private final EstadoCursoService estadoCursoService;

    @Autowired
    public EstadoCursoController(EstadoCursoService estadoCursoService) {
        this.estadoCursoService = estadoCursoService;
    }

    @SuppressWarnings("null")
    @GetMapping("/listaestadoscursos")
    public Page<EstadoCurso> getEstadosCurso(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, 
            @RequestParam(name = "orderBy", required = false, defaultValue = "idEstadoCurso") String orderBy,
            @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {

        Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        return estadoCursoService.getEstadosCurso(pageRequest);
    }
    @GetMapping("/getByIdEstadoCurso/{idEstadoCurso}")
    public Page<EstadoCurso> getByIdEstadoCurso(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @PathVariable String idEstadoCurso){

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return estadoCursoService.getByIdEstadoCurso(pageRequest, idEstadoCurso);
    }

    @GetMapping("/getByValorEstadoCurso/{valorEstadoCurso}")
    public Page<EstadoCurso> getByValorEstadoCurso(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @PathVariable String valorEstadoCurso){

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return estadoCursoService.getByValorEstadoCurso(pageRequest, valorEstadoCurso);
    }
    @PostMapping("/registrarestadocurso")
    public ResponseEntity<?> saveEstadoCurso(
            @RequestParam(name = "idEstadoCurso") String idEstadoCurso,
            @RequestParam(name = "valorEstadoCurso") String valorEstadoCurso,
            @RequestBody EstadoCurso newEstadoCurso){
        try {
            EstadoCurso saveEstadoCurso = estadoCursoService.saveEstadoCurso(newEstadoCurso, idEstadoCurso, valorEstadoCurso);
            new ResponseEntity<>(saveEstadoCurso, HttpStatus.CREATED);
            return ResponseEntity.ok("Estado curso registrado correctamente");
        } catch (EstadoCursoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/editarestadocurso")
    public ResponseEntity<?> updateEstadoCurso(
            @RequestParam(name = "idEstadoCurso") String idEstadoCurso,
            @RequestParam(name = "valorEstadoCurso") String valorEstadoCurso,
            @RequestBody EstadoCurso newEstadoCurso){
        try {
            EstadoCurso updateEstadoCurso = estadoCursoService.updateEstadoCurso(idEstadoCurso, valorEstadoCurso, newEstadoCurso);
            new ResponseEntity<>(updateEstadoCurso, HttpStatus.OK);
            return ResponseEntity.ok("Estado curso actualizado");
        } catch (EstadoCursoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarestadocurso")
    public ResponseEntity<?> deleteEstadoCurso(
            @RequestParam(name = "idEstadoCurso") String idEstadoCurso) {
        try {
            EstadoCurso deleteEstadoCurso = estadoCursoService.deleteEstadoCurso(idEstadoCurso);
            return ResponseEntity.ok("Estado curso eliminado");
        } catch (EstadoCursoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
