package com.example.EF.Repository;

import com.example.EF.Domain.Usuario;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    Optional<Usuario> findByEmailAndContrasena(String email, String contrasena);
}
