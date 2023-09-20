package com.example.EF.Service;

import com.example.EF.Domain.Equipo;
import java.util.List;

public interface EquipoService {
    public List<Equipo> Listar();
    public Equipo ConsultarId(int id);
    public Equipo Guardar(Equipo p);
    public void Eliminar(int id);
}

