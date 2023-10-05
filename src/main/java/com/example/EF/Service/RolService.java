package com.example.EF.Service;

import com.example.EF.Domain.Rol;
import java.util.List;

public interface RolService {
    public List<Rol> Listar();
    public Rol ConsultarId(String id);
    public Rol Guardar(Rol p);
    public void Eliminar(String id);
}

