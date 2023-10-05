package com.example.EF.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "etiqueta")
public class Etiqueta {
    @Id
    private String etiquetaId;
    private String nombre;
    private String color;
}
