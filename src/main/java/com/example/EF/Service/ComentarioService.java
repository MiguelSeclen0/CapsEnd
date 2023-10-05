package com.example.EF.Service;

import com.example.EF.Domain.Comentario;
import java.util.List;

public interface ComentarioService {
    public List<Comentario> Listar();
    public Comentario ConsultarId(String id);
    public Comentario Guardar(Comentario p);
    public void Eliminar(String id);
}

