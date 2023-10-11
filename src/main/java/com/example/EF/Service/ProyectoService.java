package com.example.EF.Service;

import com.example.EF.DTO.ProyectoDTO;
import com.example.EF.Domain.Proyecto;
import java.util.List;

public interface ProyectoService {
    public List<Proyecto> Listar();
    public Proyecto ConsultarId(String id);
    public Proyecto Guardar(Proyecto p);
    public void Eliminar(String id);
    public List<ProyectoDTO> buscarProyectosPorEmail(String email);
}

