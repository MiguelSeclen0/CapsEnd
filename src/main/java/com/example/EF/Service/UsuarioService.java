package com.example.EF.Service;

import com.example.EF.Domain.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<Usuario> Listar();
    public Optional<Usuario> ConsultarId(int id);
    public void Guardar(Usuario p);
    public void Eliminar(int id);
}

