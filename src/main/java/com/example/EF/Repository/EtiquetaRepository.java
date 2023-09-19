package com.example.EF.Repository;

import com.example.EF.Domain.Etiqueta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtiquetaRepository extends CrudRepository<Etiqueta, Integer>{
    
}
