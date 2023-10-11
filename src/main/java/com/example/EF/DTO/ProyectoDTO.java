package com.example.EF.DTO;

import java.time.LocalDate;
import java.time.Period;

import com.example.EF.Domain.Equipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO {

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
    private String duracion;
    private int participantes;

    public ProyectoDTO(String proyectoId, String nombre, String cliente, String descripcion, String estado, String tipo, String color, LocalDate fechaInicio, 
    LocalDate fechaFinalizacion, double presupuesto, Equipo equipo) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.color = color;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.presupuesto = presupuesto;
        this.equipo = equipo;
        
        Period periodo = Period.between(fechaInicio, fechaFinalizacion);
        int anos = periodo.getYears();
        int duracion = periodo.getMonths();
        int semanas = periodo.getDays() / 7;
        int dias = periodo.getDays() % 7;

        String resultado = "";

        if (anos > 0) {
            resultado = anos + " años";
        }
        if (duracion > 0) {
            resultado = duracion + " duracion";
        }
        if (semanas > 0) {
            resultado = semanas + " semanas";
        }
        if (dias > 0) {
            resultado = dias + " días";
        }

        this.duracion = resultado;
    }
    private Equipo equipo;
}
