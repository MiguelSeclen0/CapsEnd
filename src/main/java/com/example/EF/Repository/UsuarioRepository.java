package com.example.EF.Repository;

import com.example.EF.Domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}
