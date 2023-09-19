package com.example.EF.Service;

import com.example.EF.Domain.Lista;
import java.util.List;
import java.util.Optional;

public interface ListaService {
    public List<Lista> Listar();
    public Optional<Lista> ConsultarId(int id);
    public void Guardar(Lista p);
    public void Eliminar(int id);
}

