package com.example.EF.Controller;

import com.example.EF.Domain.Miembro;
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
import com.example.EF.Service.MiembroService;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/miembro/")
@RestController
public class MiembroController {
    @Autowired
    private MiembroService miembroService;
    
    @GetMapping(value="/all")
    public List<Miembro> getAllMiembro(){
        return miembroService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Miembro findMiembro(@PathVariable String id){
        return miembroService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Miembro> saveMiembro(@RequestBody Miembro miembro) {
        Miembro obj = miembroService.Guardar(miembro);
        return new ResponseEntity<Miembro>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Miembro> deleteMiembro(@PathVariable String id) {
        Miembro miembro = miembroService.ConsultarId(id);
        if (miembro != null) {
            miembroService.Eliminar(id);
            return new ResponseEntity<Miembro>(miembro, HttpStatus.OK);
        } else {
            return new ResponseEntity<Miembro>(HttpStatus.NO_CONTENT);
        }
    }
}


