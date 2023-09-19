package com.example.EF.Repository;

import com.example.EF.Domain.Lista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ListaRepository extends CrudRepository<Lista, Integer>{
    
}
