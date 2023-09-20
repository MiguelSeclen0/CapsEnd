package com.example.EF.Service;

import com.example.EF.Domain.Sprint;
import java.util.List;

public interface SprintService {
    public List<Sprint> Listar();
    public Sprint ConsultarId(int id);
    public Sprint Guardar(Sprint p);
    public void Eliminar(int id);
}

