package com.example.EF.Repository;

import com.example.EF.Domain.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Integer>{
    
}
