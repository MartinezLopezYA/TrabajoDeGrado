package com.example.trabajodegrado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.InsigniaRepository;
import com.example.trabajodegrado.models.Insignia;

import utils.exceptions.InsigniaException;

@Service
public class InsigniaService {

    private InsigniaRepository insigniaRepository;

    @Autowired
    public InsigniaService(InsigniaRepository insigniaRepository) {
        this.insigniaRepository = insigniaRepository;
    }

    @SuppressWarnings("null")
    public Page<Insignia> getInsignias(PageRequest pageRequest) {
        return insigniaRepository.findAll(pageRequest);
    }

    public Page<Insignia> getByTituloInsignia(PageRequest pageRequest, String tituloInsignia) {

        try {
            if (tituloInsignia.equals("")) {
                return Page.empty();
            } else {
                Page<Insignia> result = insigniaRepository.findByTituloInsignia(pageRequest, tituloInsignia);

                if (result != null && result.hasContent()) {
                    return result;
                } else {
                    return Page.empty();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return Page.empty();
        }

    }

    @SuppressWarnings("null")
    public Insignia saveInsignia(Insignia newInsignia, int idInsignia) {

        Insignia existByIdInsignia = insigniaRepository.findByIdInsignia(idInsignia);

        try {
            if (existByIdInsignia != null) {
                throw new InsigniaException("Ya existe una Insignia con el ID: " + idInsignia);
            } else {
                return insigniaRepository.save(newInsignia);
            }
        } catch (InsigniaException e) {
            throw new InsigniaException("Error al registrar la Insignia " + e);
        }

    }

    public Insignia updateInsignia(int idInsignia, Insignia newInsignia) {

        Insignia existInsigniaById = insigniaRepository.findByIdInsignia(idInsignia);

        try {
            if (existInsigniaById == null) {
                throw new InsigniaException("No se encontró la Insignia con el ID: " + idInsignia);
            } else {
                existInsigniaById.setTituloInsignia(newInsignia.getTituloInsignia());
                existInsigniaById.setFechaInsignia(newInsignia.getFechaInsignia());
                insigniaRepository.save(existInsigniaById);
                return existInsigniaById;
            }   
        } catch (InsigniaException e) {
            throw new InsigniaException("Error al actualizar la Insignia " + e);
        }

    }

    public Insignia deleteInsignia(int idInsignia) {

        Insignia existInsigniaById = insigniaRepository.findByIdInsignia(idInsignia);

        try {
            if (existInsigniaById == null) {
                throw new InsigniaException("No se encontró ninguna Insignia con el ID: " + idInsignia);
            } else {
                insigniaRepository.delete(existInsigniaById);
                return existInsigniaById;
            }
        } catch (Exception e) {
            throw new InsigniaException("Error al eliminar la Insignia " + e);
        }

    }

}
