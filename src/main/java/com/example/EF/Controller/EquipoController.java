package com.example.EF.Controller;

import com.example.EF.Domain.Equipo;
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
import com.example.EF.Service.EquipoService;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/equipo/")
@RestController
public class EquipoController {
    @Autowired
    private EquipoService equipoService;
    
    @GetMapping(value="/all")
    public List<Equipo> getAllEquipo(){
        return equipoService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Equipo findEquipo(@PathVariable String id){
        return equipoService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Equipo> saveEquipo(@RequestBody Equipo equipo) {
        Equipo obj = equipoService.Guardar(equipo);
        return new ResponseEntity<Equipo>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Equipo> deleteEquipo(@PathVariable String id) {
        Equipo equipo = equipoService.ConsultarId(id);
        if (equipo != null) {
            equipoService.Eliminar(id);
            return new ResponseEntity<Equipo>(equipo, HttpStatus.OK);
        } else {
            return new ResponseEntity<Equipo>(HttpStatus.NO_CONTENT);
        }
    }
}


