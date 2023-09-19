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
@Table(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String textoComentario;
    private Date fechaHoraComentario;

    @ManyToOne
    @JoinColumn(name = "tarjeta_id")
    private Tarjeta tarjeta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters y setters
}




