package com.example.EF.Controller;

import com.example.EF.Domain.Rol;
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
import com.example.EF.Service.RolService;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/rol/")
@RestController
public class RolController {
    @Autowired
    private RolService rolService;
    
    @GetMapping(value="/all")
    public List<Rol> getAllRol(){
        return rolService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Rol findRol(@PathVariable String id){
        return rolService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol) {
        Rol obj = rolService.Guardar(rol);
        return new ResponseEntity<Rol>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Rol> deleteRol(@PathVariable String id) {
        Rol rol = rolService.ConsultarId(id);
        if (rol != null) {
            rolService.Eliminar(id);
            return new ResponseEntity<Rol>(rol, HttpStatus.OK);
        } else {
            return new ResponseEntity<Rol>(HttpStatus.NO_CONTENT);
        }
    }
}


