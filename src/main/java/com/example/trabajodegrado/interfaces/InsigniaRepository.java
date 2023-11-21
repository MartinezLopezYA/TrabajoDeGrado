package com.example.trabajodegrado.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trabajodegrado.models.Insignia;

@Repository
public interface InsigniaRepository extends JpaRepository<Insignia, String>{
    
}
