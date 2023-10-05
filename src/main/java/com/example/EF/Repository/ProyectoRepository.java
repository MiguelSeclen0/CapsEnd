package com.example.EF.Repository;

import com.example.EF.Domain.Proyecto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProyectoRepository extends MongoRepository<Proyecto, String>{
    
}
