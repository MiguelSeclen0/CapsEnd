package com.example.EF.Service.Impl;

import com.example.EF.Domain.Usuario;
import com.example.EF.Service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public List<Usuario> Listar() {
        return (List<Usuario>)usuarioRepository.findAll(); 
    }

    @Override
    public Usuario ConsultarId(int id) {
     Optional<Usuario> obj = usuarioRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }

    @Override
    public Usuario Guardar(Usuario p) {
       return usuarioRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       usuarioRepository.deleteById(id);
    }
}
