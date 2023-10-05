package com.example.EF.Service;

import com.example.EF.Domain.Tarea;
import java.util.List;

public interface TareaService {
    public List<Tarea> Listar();
    public Tarea ConsultarId(String id);
    public Tarea Guardar(Tarea p);
    public void Eliminar(String id);
}

