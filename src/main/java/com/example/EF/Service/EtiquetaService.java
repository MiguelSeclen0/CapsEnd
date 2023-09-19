package com.example.EF.Service;

import com.example.EF.Domain.Etiqueta;
import java.util.List;
import java.util.Optional;

public interface EtiquetaService {
    public List<Etiqueta> Listar();
    public Optional<Etiqueta> ConsultarId(int id);
    public void Guardar(Etiqueta p);
    public void Eliminar(int id);
}

