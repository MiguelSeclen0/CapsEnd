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
@Table(name = "tarjeta")
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloTarjeta;
    private String descripcionTarjeta;
    private Date fechaVencimiento;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioAsignado;

    // Getters y setters
}



