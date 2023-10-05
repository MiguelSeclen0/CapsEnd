package com.example.EF.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "comentario")
public class Comentario {
    @Id
    private String comentarioId;
    private String contenido;

    private Tarea tarea;
    private Usuario usuario;
}




