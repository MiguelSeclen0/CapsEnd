package com.example.EF.Service.Impl;

import com.example.EF.Domain.Etiqueta;
import com.example.EF.Service.EtiquetaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.EtiquetaRepository;

@Service
public class EtiquetaServiceImpl implements EtiquetaService {
    
    @Autowired
    private EtiquetaRepository etiquetaRepository;
    
    @Override
    public List<Etiqueta> Listar() {
        return (List<Etiqueta>)etiquetaRepository.findAll(); 
    }

    @Override
    public Optional<Etiqueta> ConsultarId(int id) {
     return etiquetaRepository.findById(id);
    }

    @Override
    public void Guardar(Etiqueta p) {
       etiquetaRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       etiquetaRepository.deleteById(id);
    }
}
