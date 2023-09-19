package com.example.EF.Service;

import com.example.EF.Domain.Tablero;
import java.util.List;
import java.util.Optional;

public interface TableroService {
    public List<Tablero> Listar();
    public Optional<Tablero> ConsultarId(int id);
    public void Guardar(Tablero p);
    public void Eliminar(int id);
}

