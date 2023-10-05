package com.example.EF.Repository;

import com.example.EF.Domain.Etiqueta;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EtiquetaRepository extends MongoRepository<Etiqueta, String>{

}
