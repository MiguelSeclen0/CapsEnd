package com.example.EF.Domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "sprint")
public class Sprint {
    @Id
    private String sprintId;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    @DBRef
    private Proyecto proyecto;
}



