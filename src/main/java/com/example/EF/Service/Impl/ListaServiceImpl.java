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
    public Optional<Lista> ConsultarId(int id) {
     return listaRepository.findById(id);
    }

    @Override
    public void Guardar(Lista p) {
       listaRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       listaRepository.deleteById(id);
    }
}
