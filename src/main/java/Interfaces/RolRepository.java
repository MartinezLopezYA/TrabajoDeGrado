package Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, String>{
    
}
