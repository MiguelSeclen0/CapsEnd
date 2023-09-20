package com.example.EF.Service.Impl;

import com.example.EF.Domain.Tarea;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.TareaRepository;
import com.example.EF.Service.TareaService;

@Service
public class TareaServiceImpl implements TareaService {
    
    @Autowired
    private TareaRepository tareaRepository;
    
    @Override
    public List<Tarea> Listar() {
        return (List<Tarea>)tareaRepository.findAll(); 
    }

    @Override
    public Tarea ConsultarId(int id) {
     Optional<Tarea> obj = tareaRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }

    @Override
    public Tarea Guardar(Tarea p) {
       return tareaRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       tareaRepository.deleteById(id);
    }
}
