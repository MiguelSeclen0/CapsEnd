package com.example.EF.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "usuario")
public class Usuario {
    @Id
    private String usuarioId;
    private String nombre;
    private String email;
    private String contrasena;
    private double sueldo;
}


