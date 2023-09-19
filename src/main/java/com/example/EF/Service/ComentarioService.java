package com.example.EF.Service;

import com.example.EF.Domain.Comentario;
import java.util.List;
import java.util.Optional;

public interface ComentarioService {
    public List<Comentario> Listar();
    public Comentario ConsultarId(int id);
    public Comentario Guardar(Comentario p);
    public void Eliminar(int id);
}

