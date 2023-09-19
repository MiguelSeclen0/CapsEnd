package com.example.EF.Service.Impl;

import com.example.EF.Domain.Tablero;
import com.example.EF.Service.TableroService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.TableroRepository;

@Service
public class TableroServiceImpl implements TableroService {
    
    @Autowired
    private TableroRepository tableroRepository;
    
    @Override
    public List<Tablero> Listar() {
        return (List<Tablero>)tableroRepository.findAll(); 
    }

    @Override
    public Optional<Tablero> ConsultarId(int id) {
     return tableroRepository.findById(id);
    }

    @Override
    public void Guardar(Tablero p) {
       tableroRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       tableroRepository.deleteById(id);
    }
}
