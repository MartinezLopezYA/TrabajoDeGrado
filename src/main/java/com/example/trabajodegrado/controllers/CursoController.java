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

import com.example.trabajodegrado.models.Curso;
import com.example.trabajodegrado.services.CursoService;

@RestController
@RequestMapping("curso")
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController {
    
    private CursoService cursoService;

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

    @PostMapping("/registrarcurso/{idCurso}/{nombreCurso}")
    public String saveCurso(
            @PathVariable String idCurso,
            @PathVariable String nombreCurso,
            @RequestBody Curso newCurso) {
        return cursoService.saveCurso(newCurso, idCurso, nombreCurso);
    }

    @PutMapping("/editarcurso/{idCurso}")
    public String updateCurso(
            @PathVariable String idCurso,
            @RequestBody Curso newCurso) {
        return cursoService.updateCurso(idCurso, newCurso);
    }

    @DeleteMapping("/eliminarcurso")
    public String deleteCurso(
            @RequestParam(name = "idCurso") String idCurso) {
        return cursoService.deleteCurso(idCurso);
    }

}
