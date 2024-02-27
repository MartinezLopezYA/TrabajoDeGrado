package com.example.trabajodegrado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.trabajodegrado.interfaces.CursoRepository;
import com.example.trabajodegrado.models.Curso;
import utils.exceptions.CursoException;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Page<Curso> getCursos(PageRequest pageRequest) {
        return cursoRepository.findAll(pageRequest);
    }

    public Page<Curso> getByIdCurso(PageRequest pageRequest, String idCurso) {
        if (idCurso == null) {
            return Page.empty();
        } else {
            Page<Curso> result = cursoRepository.findByIdCurso(pageRequest, idCurso);

            if (result != null && result.hasContent()) {
                return result;
            } else {
                return Page.empty();
            }
        }
    }

    public Page<Curso> getByNombreCurso(PageRequest pageRequest, String nombreCurso){
        if (nombreCurso == null){
            return Page.empty();
        } else {
            Page<Curso> result = cursoRepository.findByNombreCurso(pageRequest, nombreCurso);

            if (result != null && result.hasContent()){
                return result;
            } else {
                return Page.empty();
            }
        }
    }

    public Curso saveCurso(Curso newCurso, String idCurso, String nombreCurso) {
        Curso existCurso = cursoRepository.findByIdCurso(idCurso);
        Curso existNombreCurso = cursoRepository.findByNombreCurso(nombreCurso);

        if (existCurso != null){
            throw new CursoException("Ya existe un curso con el ID " + idCurso);
        } else if (existNombreCurso != null){
            throw new CursoException("El nombre de este curso ya existe");
        } else {
            return cursoRepository.save(newCurso);
        }
    }

    public Curso updateCurso(String idCurso, String nombreCurso, Curso newCurso) {
        Curso existCurso = cursoRepository.findByIdCurso(idCurso);
        Curso existCursoBynombre = cursoRepository.findByNombreCurso(nombreCurso);

        if (existCurso == null){
            throw new CursoException("No se encontro ningun curso con el ID " + idCurso);
        } else if (existCursoBynombre != null) {
            throw new CursoException("El nombre de este curso ya existe");
        } else {
                existCurso.setNombreCurso(newCurso.getNombreCurso());
                existCurso.setDescripcionCurso(newCurso.getDescripcionCurso());
                cursoRepository.save(existCurso);
                return existCurso;
        }
    }


    public Curso deleteCurso(String idCurso) {
        Curso existCurso = cursoRepository.findByIdCurso(idCurso);

        if (existCurso == null){
            throw new CursoException("No se encontro ningun curso con el ID " + idCurso);
        } else {
            cursoRepository.delete(existCurso);
            return existCurso;
        }
    }

}
