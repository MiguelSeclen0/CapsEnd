package com.example.EF.Domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "tarea")
public class Tarea {
    @Id
    private String tareaId;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;
    private String estado;
    private String color;

    @DBRef
    private Etiqueta etiqueta;
    
    @DBRef
    private Sprint sprint;
}
