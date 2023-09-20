package com.example.EF.Service.Impl;

import com.example.EF.Domain.Sprint;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EF.Repository.SprintRepository;
import com.example.EF.Service.SprintService;

@Service
public class SprintServiceImpl implements SprintService {
    
    @Autowired
    private SprintRepository sprintRepository;
    
    @Override
    public List<Sprint> Listar() {
        return (List<Sprint>)sprintRepository.findAll(); 
    }

    @Override
    public Sprint ConsultarId(int id) {
     Optional<Sprint> obj = sprintRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }

    @Override
    public Sprint Guardar(Sprint p) {
       return sprintRepository.save(p);
    }

    @Override
    public void Eliminar(int id) {
       sprintRepository.deleteById(id);
    }
}
