package com.example.EF.Service;

import com.example.EF.Domain.Proyecto;
import java.util.List;
import java.util.Optional;

public interface ProyectoService {
    public List<Proyecto> Listar();
    public Optional<Proyecto> ConsultarId(int id);
    public void Guardar(Proyecto p);
    public void Eliminar(int id);
}

