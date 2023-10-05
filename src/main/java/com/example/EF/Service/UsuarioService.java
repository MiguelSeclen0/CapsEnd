package com.example.EF.Service;

import com.example.EF.Domain.Usuario;
import java.util.List;

public interface UsuarioService {
    public List<Usuario> Listar();
    public Usuario ConsultarId(String id);
    public Usuario Guardar(Usuario p);
    public void Eliminar(String id);
    public Usuario ValLogin(String email, String contra);
}

