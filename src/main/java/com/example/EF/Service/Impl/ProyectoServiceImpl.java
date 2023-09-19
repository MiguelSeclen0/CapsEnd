package com.example.EF.Service.Impl;

import com.example.EF.Domain.Proyecto;
import com.example.EF.Service.ProyectoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {
    
    @Autowired
    private ProyectoRepository proyectoRepository;
    
    @Override
    public List<Proyecto> Listar() {
        return (List<Proyecto>)proyectoRepository.findAll(); 
    }

    @Override
    public Proyecto ConsultarId(int id) {
     Optional<Proyecto> obj = proyectoRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }

    @Override
    public Proyecto Guardar(Proyecto p) {
       return proyectoRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       proyectoRepository.deleteById(id);
    }
}
