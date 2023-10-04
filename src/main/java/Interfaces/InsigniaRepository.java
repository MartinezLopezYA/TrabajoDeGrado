package Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Models.Insignia;

@Repository
public interface InsigniaRepository extends JpaRepository<Insignia, String>{
    
}
