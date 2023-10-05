package com.example.EF.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "rol")
public class Rol {

    @Id
    private String rolId;
    private String nombre;
}