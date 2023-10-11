package com.example.EF.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "miembro")
public class Miembro {
    @Id
    private String miembroId;

    @DBRef
    private Usuario usuario;

    @DBRef
    private Equipo equipo;

    @DBRef
    private Rol rol;
}
