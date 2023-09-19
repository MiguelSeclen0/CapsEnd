package com.example.EF.Service.Impl;

import com.example.EF.Domain.Tarjeta;
import com.example.EF.Service.TarjetaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.TarjetaRepository;

@Service
public class TarjetaServiceImpl implements TarjetaService {
    
    @Autowired
    private TarjetaRepository tarjetaRepository;
    
    @Override
    public List<Tarjeta> Listar() {
        return (List<Tarjeta>)tarjetaRepository.findAll(); 
    }

    @Override
    public Optional<Tarjeta> ConsultarId(int id) {
     return tarjetaRepository.findById(id);
    }

    @Override
    public void Guardar(Tarjeta p) {
       tarjetaRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       tarjetaRepository.deleteById(id);
    }
}
