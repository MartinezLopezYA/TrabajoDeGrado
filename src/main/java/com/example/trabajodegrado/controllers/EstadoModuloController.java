package com.example.trabajodegrado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.trabajodegrado.models.EstadoModulo;
import com.example.trabajodegrado.services.EstadoModuloService;
import utils.exceptions.EstadoModuloException;

@RestController
@RequestMapping("estadomodulo")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoModuloController {

    private final EstadoModuloService estadoModuloService;

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

    @GetMapping("/getByIdEstadoModulo/{idEstadoModulo}")
    public Page<EstadoModulo> getByIdEstadoModulo(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @PathVariable String idEstadoModulo) {

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return estadoModuloService.getByIdEstadoModulo(pageRequest, idEstadoModulo);
    }

    @GetMapping("/getByValorEstadoModulo/{valorEstadoModulo}")
    public Page<EstadoModulo> getByValorEstadoModulo(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @PathVariable String valorEstadoModulo) {

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return estadoModuloService.getByValorEstadoModulo(pageRequest, valorEstadoModulo);
    }

    @PostMapping("/registrarestadomodulo")
    public ResponseEntity<?> saveEstadoModulo(
            @RequestParam(name = "idEstadoModulo") String idEstadoModulo,
            @RequestParam(name = "valorEstadoModulo") String valorEstadoModulo,
            @RequestBody EstadoModulo newEstadoModulo) {
        try {
            EstadoModulo saveEstadoModulo = estadoModuloService.saveEstadoModulo(newEstadoModulo, idEstadoModulo, valorEstadoModulo);
            new ResponseEntity<>(saveEstadoModulo, HttpStatus.CREATED);
            return ResponseEntity.ok("Estado modulo registrado correctamente");
        } catch (EstadoModuloException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/editarestadomodulo")
    public ResponseEntity<?> updateEstadoModulo(
            @RequestParam(name = "idEstadoModulo") String idEstadoModulo,
            @RequestParam(name = "valorEstadoModulo") String valorEstadoModulo,
            @RequestBody EstadoModulo newEstadoModulo){
        try {
            EstadoModulo updateEstadoModulo = estadoModuloService.updateEstadoModulo(idEstadoModulo, valorEstadoModulo, newEstadoModulo);
            new ResponseEntity<>(updateEstadoModulo, HttpStatus.OK);
            return ResponseEntity.ok("Estado modulo actualizado");
        } catch (EstadoModuloException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarestadomodulo")
    public ResponseEntity<?> deleteEstadoModulo(
            @RequestParam(name = "idEstadoModulo") String idEstadoModulo) {
        try {
            EstadoModulo deleteEstadoModulo = estadoModuloService.deleteEstadoModulo(idEstadoModulo);
            return ResponseEntity.ok("Estado modulo eliminado");
        } catch (EstadoModuloException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
