package com.example.EF.Repository;

import com.example.EF.Domain.Tablero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TableroRepository extends CrudRepository<Tablero, Integer>{
    
}
