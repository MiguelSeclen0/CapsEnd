package com.example.EF.Controller;

import com.example.EF.Domain.Etiqueta;
import com.example.EF.Service.EtiquetaService;
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
@RequestMapping(value = "/etiqueta/")
@RestController
public class EtiquetaController {
    @Autowired
    private EtiquetaService etiquetaService;
    
    @GetMapping(value="/all")
    public List<Etiqueta> getAllEtiqueta(){
        return etiquetaService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Etiqueta findEtiqueta(@PathVariable String id){
        return etiquetaService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Etiqueta> saveEtiqueta(@RequestBody Etiqueta etiqueta) {
        Etiqueta obj = etiquetaService.Guardar(etiqueta);
        return new ResponseEntity<Etiqueta>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Etiqueta> deleteEtiqueta(@PathVariable String id) {
        Etiqueta etiqueta = etiquetaService.ConsultarId(id);
        if (etiqueta != null) {
            etiquetaService.Eliminar(id);
            return new ResponseEntity<Etiqueta>(etiqueta, HttpStatus.OK);
        } else {
            return new ResponseEntity<Etiqueta>(HttpStatus.NO_CONTENT);
        }
    }
}


