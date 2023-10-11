package com.example.EF.Controller;

import com.example.EF.Domain.Tarea;
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
import com.example.EF.Service.TareaService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/tarea/")
@RestController
public class TareaController {
    @Autowired
    private TareaService tareaService;
    
    @GetMapping(value="/all")
    public List<Tarea> getAllTarea(){
        return tareaService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Tarea findTarea(@PathVariable String id){
        return tareaService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Tarea> saveTarea(@RequestBody Tarea tarea) {
        Tarea obj = tareaService.Guardar(tarea);
        return new ResponseEntity<Tarea>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Tarea> deleteTarea(@PathVariable String id) {
        Tarea tarea = tareaService.ConsultarId(id);
        if (tarea != null) {
            tareaService.Eliminar(id);
            return new ResponseEntity<Tarea>(tarea, HttpStatus.OK);
        } else {
            return new ResponseEntity<Tarea>(HttpStatus.NO_CONTENT);
        }
    }
}


