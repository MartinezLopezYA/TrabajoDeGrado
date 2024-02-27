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

import com.example.trabajodegrado.models.Curso;
import com.example.trabajodegrado.services.CursoService;
import utils.exceptions.CursoException;

@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController {
    
    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/listacursos")
    public Page<Curso> getCursos(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize, 
            @RequestParam(name = "orderBy", required = false, defaultValue = "idCurso") String orderBy,
            @RequestParam(name = "direction", required = false, defaultValue = "asc") String direction) {

        Sort sort = Sort.by(Sort.Direction.fromString(direction), orderBy);
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        return cursoService.getCursos(pageRequest);
    }

    @GetMapping("/getByIdCurso/{idCurso}")
    public Page<Curso> getByIdCurso(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @PathVariable String idCurso){

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return cursoService.getByIdCurso(pageRequest, idCurso);
    }

    @GetMapping("/getByNombreCurso{nombreCurso}")
    public Page<Curso> getByNombreCurso(
            @RequestParam(name = "startIndex", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @PathVariable String nombreCurso){

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return cursoService.getByNombreCurso(pageRequest, nombreCurso);
    }

    @PostMapping("/registrarcurso")
    public ResponseEntity<?> saveCurso(
            @RequestParam(name = "idCurso") String idCurso,
            @RequestParam(name = "nombreCurso") String nombreCurso,
            @RequestBody Curso newCurso) {
        try {
            Curso saveCurso = cursoService.saveCurso(newCurso, idCurso, nombreCurso);
            new ResponseEntity<>(saveCurso, HttpStatus.CREATED);
            return ResponseEntity.ok("Curso Registrado correctamente");
        } catch (CursoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/editarcurso")
    public ResponseEntity<?> updateCurso(
            @RequestParam(name = "idCurso") String idCurso,
            @RequestParam(name = "nombreCurso") String nombreCurso,
            @RequestBody Curso newCurso) {
        try {
            Curso updateCurso = cursoService.updateCurso(idCurso, nombreCurso, newCurso);
            new ResponseEntity<>(updateCurso, HttpStatus.OK);
            return ResponseEntity.ok("Curso actualizado");
        } catch (CursoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarcurso")
    public ResponseEntity<?> deleteCurso(
            @RequestParam(name = "idCurso") String idCurso) {
        try {
            Curso deleteCurso = cursoService.deleteCurso(idCurso);
            return ResponseEntity.ok("Curso eliminado");
        } catch (CursoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
