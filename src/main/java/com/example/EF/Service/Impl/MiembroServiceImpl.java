package com.example.EF.Service.Impl;

import com.example.EF.Domain.Equipo;
import com.example.EF.Domain.Miembro;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.MiembroRepository;
import com.example.EF.Service.MiembroService;

@Service
public class MiembroServiceImpl implements MiembroService {
    
    @Autowired
    private MiembroRepository miembroRepository;
    
    @Override
    public List<Miembro> Listar() {
        return (List<Miembro>)miembroRepository.findAll(); 
    }

    @Override
    public Miembro ConsultarId(String id) {
     Optional<Miembro> obj = miembroRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }else return null;
    }

    @Override
    public Miembro Guardar(Miembro p) {
       return miembroRepository.save(p);
    }

    @Override
    public void Eliminar(String id) {
       miembroRepository.deleteById(id);
    }
    @Override
    // Este método devuelve una lista de miembros asociados a un equipo específico
    public List<Miembro> obtenerMiembrosPorEquipo(Equipo equipo) {
        return miembroRepository.findByEquipo(equipo);
    }
}
