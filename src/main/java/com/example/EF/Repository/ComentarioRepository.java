package com.example.EF.Repository;

import com.example.EF.Domain.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Integer>{
    
}
