package com.example.EF.Domain;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProyecto;
    private String descripcionProyecto;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    // Otros campos relevantes para la gestión de proyectos

    // Getters y setters
}

