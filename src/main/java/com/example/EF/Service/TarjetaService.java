package com.example.EF.Service;

import com.example.EF.Domain.Tarjeta;
import java.util.List;
import java.util.Optional;

public interface TarjetaService {
    public List<Tarjeta> Listar();
    public Optional<Tarjeta> ConsultarId(int id);
    public void Guardar(Tarjeta p);
    public void Eliminar(int id);
}

