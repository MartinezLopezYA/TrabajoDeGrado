package interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Insignia;

@Repository
public interface InsigniaRepository extends JpaRepository<Insignia, String>{
    
}
