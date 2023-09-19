package com.example.EF.Controller;

import com.example.EF.Domain.Proyecto;
import com.example.EF.Service.ProyectoService;
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
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;
    
    @GetMapping(value="/all")
    public List<Proyecto> getAllProyecto(){
        return proyectoService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Proyecto findProyecto(@PathVariable int id){
        return proyectoService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Proyecto> saveProyecto(@RequestBody Proyecto proyecto) {
        Proyecto obj = proyectoService.Guardar(proyecto);
        return new ResponseEntity<Proyecto>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Proyecto> deleteProyecto(@PathVariable int id) {
        Proyecto proyecto = proyectoService.ConsultarId(id);
        if (proyecto != null) {
            proyectoService.Eliminar(id);
            return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Proyecto>(HttpStatus.NO_CONTENT);
        }
    }
}


