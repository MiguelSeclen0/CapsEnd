package com.example.EF.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreUsuario;
    private String correoElectronico;
    private String contrasena;
    // Otros detalles de usuario, como nombre completo, rol, etc.

    // Getters y setters
}


