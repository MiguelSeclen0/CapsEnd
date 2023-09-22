package com.example.EF.Repository;

import com.example.EF.Domain.Usuario;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    Optional<Usuario> findByEmail(String email);
}
