package com.example.trabajodegrado.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trabajodegrado.interfaces.InsigniaRepository;
import com.example.trabajodegrado.models.Insignia;

@Service
public class InsigniaService {
    
    private InsigniaRepository insigniaRepository;

    @Autowired
    public InsigniaService(InsigniaRepository insigniaRepository) {
        this.insigniaRepository = insigniaRepository;
    }

    public Page<Insignia> getInsignias(PageRequest pageRequest) {
        return insigniaRepository.findAll(pageRequest);
    }

    public Page<Insignia> getByTituloInsignia(PageRequest pageRequest, String tituloInsignia) {
        
        try{
            if (tituloInsignia.equals("")){
                return Page.empty();
            } else {
                Page<Insignia> result = insigniaRepository.findByTituloInsignia(pageRequest, tituloInsignia);
                
                if (result != null && result.hasContent()){
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

    public String saveInsignia(Insignia newinsignia, Integer idinsignia) {

        Optional<Insignia> existById = insigniaRepository.findById(idinsignia);

        try {
            if (insigniaRepository.existsById(idinsignia)) {
                return "Ya existe insignia con ese codigo: " + existById.toString();
            } else {
                insigniaRepository.save(newinsignia);
                return "Insignia registrado con exito";
            }
        } catch (Exception e) {
            return "Error al registrar el insignia " + e;
        }

    }

    public String updateInsignia(Integer idinsignia, Insignia newinsignia) {

        Optional<Insignia> existinsignia = insigniaRepository.findById(idinsignia);

        try {
            if (existinsignia.isPresent()) {

                Insignia exist = existinsignia.get();

                exist.setTituloInsignia(newinsignia.getTituloInsignia());
                exist.setFechaInsignia(newinsignia.getFechaInsignia());

                insigniaRepository.save(exist);

                return "insignia actualizado con exito: \n" + exist.toString();

            } else {
                return "No existe ningún insignia con este Id";
            }
        } catch (Exception e) {
            return "Error al actualizar el insignia";
        }

    }

    public String deleteInsignia(Integer idinsignia) {

        try {
            Insignia insignia = insigniaRepository.findById(idinsignia).get();
            insigniaRepository.delete(insignia);
            return "Registro eliminado de la tabla insignia";
        } catch (Exception e) {
            return "No se pudo completar la ejecución de la tabla insignia" + e;
        }

    }

}
