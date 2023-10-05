package com.example.EF.Repository;

import com.example.EF.Domain.Tarea;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TareaRepository extends MongoRepository<Tarea, String>{
    
}
