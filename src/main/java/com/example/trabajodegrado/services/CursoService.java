package com.example.trabajodegrado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.CursoRepository;
import com.example.trabajodegrado.models.Curso;

@Service
public class CursoService {

    private CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Page<Curso> getCursos(PageRequest pageRequest) {
        return cursoRepository.findAll(pageRequest);
    }

    public String saveCurso(Curso newcurso, String idcurso, String nombreCurso) {

        Optional<Curso> existById = cursoRepository.findById(idcurso);
        Curso existByNombreCurso = cursoRepository.findByNombreCurso(nombreCurso);

        try {
            if (cursoRepository.existsById(idcurso)) {
                return "Ya existe curso con ese codigo: " + existById.toString();
            } else if (existByNombreCurso != null && existByNombreCurso.getNombreCurso().equals(newcurso.getNombreCurso())) {
                return "Ya existe curso con ese nombre: " + existByNombreCurso.getNombreCurso();
            } else {
                cursoRepository.save(newcurso);
                return "Rol registrado con exito";
            }
        } catch (Exception e) {
            return "Error al registrar el curso " + e;
        }

    }

    public String updateCurso(String idcurso, Curso newcurso) {

        Optional<Curso> existcurso = cursoRepository.findById(idcurso);

        try {
            if (existcurso.isPresent()) {

                Curso exist = existcurso.get();

                exist.setNombreCurso(newcurso.getNombreCurso());
                exist.setDescripcionCurso(newcurso.getDescripcionCurso());

                cursoRepository.save(exist);

                return "curso actualizado con exito: \n" + exist.toString();

            } else {
                return "No existe ningún curso con este Id";
            }
        } catch (Exception e) {
            return "Error al actualizar el curso";
        }

    }

    public String deleteCurso(String idcurso) {

        try {
            Curso curso = cursoRepository.findById(idcurso).get();
            cursoRepository.delete(curso);
            return "Registro eliminado de la tabla curso";
        } catch (Exception e) {
            return "No se pudo completar la ejecución de la tabla curso" + e;
        }

    }
    
}
