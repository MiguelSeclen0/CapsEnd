package com.example.EF.Service.Impl;

import com.example.EF.DTO.ProyectoDTO;
import com.example.EF.Domain.Miembro;
import com.example.EF.Domain.Proyecto;
import com.example.EF.Service.MiembroService;
import com.example.EF.Service.ProyectoService;

import java.io.Console;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EF.Repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {
    
    @Autowired
    private ProyectoRepository proyectoRepository;
    
    public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @Autowired
    private MiembroService miembroService;

    @Override
    public List<Proyecto> Listar() {
        return (List<Proyecto>)proyectoRepository.findAll(); 
    }

    @Override
    public Proyecto ConsultarId(String id) {
     Optional<Proyecto> obj = proyectoRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }

    @Override
    public Proyecto Guardar(Proyecto p) {
       return proyectoRepository.save(p);
    }

    @Override
    public void Eliminar(String id) {
       proyectoRepository.deleteById(id);
    }

    @Override
    public List<ProyectoDTO> buscarProyectosPorEmail(String email) {
        
        List<Proyecto> proyectos = proyectoRepository.findByEquipo_EquipoId(email);
        System.out.println(email);
        System.out.println(proyectos);
        return proyectos.stream()
                .map(this::convertirProyectoAProyectoDTO)
                .collect(Collectors.toList());
    }

    public ProyectoDTO convertirProyectoAProyectoDTO(Proyecto proyecto) {
        ProyectoDTO proyectoDTO = new ProyectoDTO(
            proyecto.getProyectoId(),
            proyecto.getNombre(),
            proyecto.getCliente(),
            proyecto.getDescripcion(),
            proyecto.getEstado(),
            proyecto.getTipo(),
            proyecto.getColor(),
            proyecto.getFechaInicio(),
            proyecto.getFechaFinalizacion(),
            proyecto.getPresupuesto(),
            proyecto.getEquipo()
        );

        // Calcular el número de participantes en el proyecto
        int participantes = calcularNumeroDeParticipantes(proyecto);
        proyectoDTO.setParticipantes(participantes);

        return proyectoDTO;
    }

    private int calcularNumeroDeParticipantes(Proyecto proyecto) {
        // Suponiendo que tienes acceso a un servicio de miembros
        // (MiembroService) que puede buscar miembros por equipo
        List<Miembro> miembros = miembroService.obtenerMiembrosPorEquipo(proyecto.getEquipo());
        return miembros.size();
    }
}
