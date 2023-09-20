package com.example.EF.Service;

import com.example.EF.Domain.Tarea;
import java.util.List;
import java.util.Optional;

public interface TareaService {
    public List<Tarea> Listar();
    public Tarea ConsultarId(int id);
    public Tarea Guardar(Tarea p);
    public void Eliminar(int id);
}

