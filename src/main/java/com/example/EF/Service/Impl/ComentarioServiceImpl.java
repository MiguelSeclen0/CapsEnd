package com.example.EF.Service.Impl;

import com.example.EF.Domain.Comentario;
import com.example.EF.Service.ComentarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.ComentarioRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Override
    public List<Comentario> Listar() {
        return (List<Comentario>)comentarioRepository.findAll(); 
    }

    @Override
    public Comentario ConsultarId(int id) {
        Optional<Comentario> obj = comentarioRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }else return null;
    }

    @Override
    public Comentario Guardar(Comentario p) {
       return comentarioRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       comentarioRepository.deleteById(id);
    }
}
