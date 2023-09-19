package com.example.EF.Controller;

import com.example.EF.Domain.Lista;
import com.example.EF.Service.ListaService;
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
@RequestMapping(value = "/lista/")
@RestController
public class ListaController {
    @Autowired
    private ListaService listaService;
    
    @GetMapping(value="/all")
    public List<Lista> getAllLista(){
        return listaService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Lista findLista(@PathVariable int id){
        return listaService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Lista> saveLista(@RequestBody Lista lista) {
        Lista obj = listaService.Guardar(lista);
        return new ResponseEntity<Lista>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Lista> deleteLista(@PathVariable int id) {
        Lista lista = listaService.ConsultarId(id);
        if (lista != null) {
            listaService.Eliminar(id);
            return new ResponseEntity<Lista>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<Lista>(HttpStatus.NO_CONTENT);
        }
    }
}


