package com.example.EF.Controller;

import com.example.EF.DTO.ProyectoDTO;
import com.example.EF.Domain.Proyecto;
import com.example.EF.Service.ProyectoService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/proyecto/")
@RestController
@RequiredArgsConstructor
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;
    
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }
    @GetMapping(value="/all")
    public List<Proyecto> getAllProyecto(){
        return proyectoService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Proyecto findProyecto(@PathVariable String id){
        return proyectoService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Proyecto> saveProyecto(@RequestBody Proyecto proyecto) {
        Proyecto obj = proyectoService.Guardar(proyecto);
        return new ResponseEntity<Proyecto>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Proyecto> deleteProyecto(@PathVariable String id) {
        Proyecto proyecto = proyectoService.ConsultarId(id);
        if (proyecto != null) {
            proyectoService.Eliminar(id);
            return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Proyecto>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/findByEmail")
    public ResponseEntity<List<ProyectoDTO>> findProyectosPorEmail(@RequestBody String email) {
        // Utiliza el servicio para buscar proyectos por el email del usuario
        List<ProyectoDTO> proyectosDTO = proyectoService.buscarProyectosPorEmail(email);
        
        if (proyectosDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(proyectosDTO, HttpStatus.OK);
        }
    }
}


