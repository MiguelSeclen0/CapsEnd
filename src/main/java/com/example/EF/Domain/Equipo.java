package com.example.EF.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "equipo")
public class Equipo {
    @Id
    private String equipoId;
    private String nombre;
}
