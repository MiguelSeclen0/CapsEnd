package com.example.EF.Service.Impl;

import com.example.EF.Domain.Lista;
import com.example.EF.Service.ListaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.ListaRepository;

@Service
public class ListaServiceImpl implements ListaService {
    
    @Autowired
    private ListaRepository listaRepository;
    
    @Override
    public List<Lista> Listar() {
        return (List<Lista>)listaRepository.findAll(); 
    }

    @Override
    public Lista ConsultarId(int id) {
     Optional<Lista> obj = listaRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }else return null;
    }

    @Override
    public Lista Guardar(Lista p) {
       return listaRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       listaRepository.deleteById(id);
    }
}
