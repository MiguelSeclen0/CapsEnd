package com.example.EF.Repository;

import com.example.EF.Domain.Equipo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EquipoRepository extends MongoRepository<Equipo, String>{

}
