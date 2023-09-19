package com.example.EF.Controller;

import com.example.EF.Domain.Tablero;
import com.example.EF.Service.TableroService;
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
@RequestMapping(value = "/tablero/")
@RestController
public class TableroController {
    @Autowired
    private TableroService tableroService;
    
    @GetMapping(value="/all")
    public List<Tablero> getAllTablero(){
        return tableroService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Tablero findTablero(@PathVariable int id){
        return tableroService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Tablero> saveTablero(@RequestBody Tablero tablero) {
        Tablero obj = tableroService.Guardar(tablero);
        return new ResponseEntity<Tablero>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Tablero> deleteTablero(@PathVariable int id) {
        Tablero tablero = tableroService.ConsultarId(id);
        if (tablero != null) {
            tableroService.Eliminar(id);
            return new ResponseEntity<Tablero>(tablero, HttpStatus.OK);
        } else {
            return new ResponseEntity<Tablero>(HttpStatus.NO_CONTENT);
        }
    }
}


