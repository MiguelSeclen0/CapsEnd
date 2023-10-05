package com.example.EF.Service;

import com.example.EF.Domain.Miembro;
import java.util.List;

public interface MiembroService {
    public List<Miembro> Listar();
    public Miembro ConsultarId(String id);
    public Miembro Guardar(Miembro p);
    public void Eliminar(String id);
}

