package com.example.EF.Service.Impl;

import com.example.EF.Domain.Rol;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.RolRepository;
import com.example.EF.Service.RolService;

@Service
public class RolServiceImpl implements RolService {
    
    @Autowired
    private RolRepository rolRepository;
    
    @Override
    public List<Rol> Listar() {
        return (List<Rol>)rolRepository.findAll(); 
    }

    @Override
    public Rol ConsultarId(String id) {
     Optional<Rol> obj = rolRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }else return null;
    }

    @Override
    public Rol Guardar(Rol p) {
       return rolRepository.save(p);
    }

    @Override
    public void Eliminar(String id) {
       rolRepository.deleteById(id);
    }
}
