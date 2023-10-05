package com.example.EF.Service;

import com.example.EF.Domain.Etiqueta;
import java.util.List;

public interface EtiquetaService {
    public List<Etiqueta> Listar();
    public Etiqueta ConsultarId(String id);
    public Etiqueta Guardar(Etiqueta p);
    public void Eliminar(String id);
}

