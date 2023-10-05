package com.example.EF.Repository;

import com.example.EF.Domain.Rol;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RolRepository extends MongoRepository<Rol, String>{
    
}
