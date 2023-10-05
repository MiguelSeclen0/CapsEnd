package com.example.EF.Repository;

import com.example.EF.Domain.Comentario;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String>{

}
