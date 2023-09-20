package com.example.EF.Domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String cliente;
    private String descripcion;
    private String estado;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    // Getters y setters
}

