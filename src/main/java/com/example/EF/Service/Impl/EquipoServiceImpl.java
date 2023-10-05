package com.example.EF.Service.Impl;

import com.example.EF.Domain.Equipo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.EquipoRepository;
import com.example.EF.Service.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {
    
    @Autowired
    private EquipoRepository equipoRepository;
    
    @Override
    public List<Equipo> Listar() {
        return (List<Equipo>)equipoRepository.findAll(); 
    }

    @Override
    public Equipo ConsultarId(String id) {
     Optional<Equipo> obj = equipoRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }else return null;
    }

    @Override
    public Equipo Guardar(Equipo p) {
       return equipoRepository.save(p);
    }

    @Override
    public void Eliminar(String id) {
       equipoRepository.deleteById(id);
    }
}
