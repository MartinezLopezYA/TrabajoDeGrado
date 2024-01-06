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

import com.example.trabajodegrado.models.Insignia;
import com.example.trabajodegrado.services.InsigniaService;

@RestController
@RequestMapping("insignia")
@CrossOrigin(origins = "http://localhost:4200")
public class InsigniaController {
    
    private InsigniaService insigniaService;

    @Autowired
    public InsigniaController(InsigniaService insigniaService) {
        this.insigniaService = insigniaService;
    }

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
    public String saveInsignia(
            @PathVariable Integer idInsignia,
            @RequestBody Insignia newInsignia) {
        return insigniaService.saveInsignia(newInsignia, idInsignia);
    }

    @PutMapping("/editarinsignia/{idInsignia}")
    public String updateInsignia(
            @PathVariable Integer idInsignia,
            @RequestBody Insignia newInsignia) {
        return insigniaService.updateInsignia(idInsignia, newInsignia);
    }

    @DeleteMapping("/eliminarinsignia")
    public String deleteInsignia(
            @RequestParam(name = "idInsignia") Integer idInsignia) {
        return insigniaService.deleteInsignia(idInsignia);
    }
}
