package com.example.EF.Service;

import com.example.EF.Domain.Lista;
import java.util.List;
import java.util.Optional;

public interface ListaService {
    public List<Lista> Listar();
    public Lista ConsultarId(int id);
    public Lista Guardar(Lista p);
    public void Eliminar(int id);
}

