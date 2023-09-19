package com.example.EF.Repository;

import com.example.EF.Domain.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Integer>{
    
}
