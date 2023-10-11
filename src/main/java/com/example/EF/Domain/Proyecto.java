package com.example.EF.Domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "proyecto")
public class Proyecto {
    @Id
    private String proyectoId;
    private String nombre;
    private String cliente;
    private String descripcion;
    private String estado;
    private String tipo;
    private String color;
    private LocalDate fechaInicio;
    private LocalDate fechaFinalizacion;
    private double presupuesto;
    
    
    @DBRef
    private Equipo equipo;

}

