package com.example.EF.Repository;

import com.example.EF.Domain.Tarjeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Integer>{
    
}
