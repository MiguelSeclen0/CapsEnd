package com.example.EF.Service;

import com.example.EF.Domain.Tarjeta;
import java.util.List;
import java.util.Optional;

public interface TarjetaService {
    public List<Tarjeta> Listar();
    public Tarjeta ConsultarId(int id);
    public Tarjeta Guardar(Tarjeta p);
    public void Eliminar(int id);
}

