package com.example.EF.Repository;

import com.example.EF.Domain.Equipo;
import com.example.EF.Domain.Miembro;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;




@Repository
public interface MiembroRepository extends MongoRepository<Miembro, String>{
    List<Miembro> findByEquipo(Equipo equipo);
}
