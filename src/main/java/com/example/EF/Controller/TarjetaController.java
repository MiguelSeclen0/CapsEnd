package com.example.EF.Controller;

import com.example.EF.Domain.Tarjeta;
import com.example.EF.Service.TarjetaService;
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
@RequestMapping(value = "/tarjeta/")
@RestController
public class TarjetaController {
    @Autowired
    private TarjetaService tarjetaService;
    
    @GetMapping(value="/all")
    public List<Tarjeta> getAllTarjeta(){
        return tarjetaService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Tarjeta findTarjeta(@PathVariable int id){
        return tarjetaService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Tarjeta> saveTarjeta(@RequestBody Tarjeta tarjeta) {
        Tarjeta obj = tarjetaService.Guardar(tarjeta);
        return new ResponseEntity<Tarjeta>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Tarjeta> deleteTarjeta(@PathVariable int id) {
        Tarjeta tarjeta = tarjetaService.ConsultarId(id);
        if (tarjeta != null) {
            tarjetaService.Eliminar(id);
            return new ResponseEntity<Tarjeta>(tarjeta, HttpStatus.OK);
        } else {
            return new ResponseEntity<Tarjeta>(HttpStatus.NO_CONTENT);
        }
    }
}


