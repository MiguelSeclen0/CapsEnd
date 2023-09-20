package com.example.EF.Repository;

import com.example.EF.Domain.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TareaRepository extends CrudRepository<Tarea, Integer>{
    
}
