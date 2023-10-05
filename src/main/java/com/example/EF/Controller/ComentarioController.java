package com.example.EF.Controller;

import com.example.EF.Domain.Comentario;
import com.example.EF.Service.ComentarioService;
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
@RequestMapping(value = "/comentario/")
@RestController
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;
    
    @GetMapping(value="/all")
    public List<Comentario> getAllComentario(){
        return comentarioService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Comentario findComentario(@PathVariable String id){
        return comentarioService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Comentario> saveComentario(@RequestBody Comentario comentario) {
        Comentario obj = comentarioService.Guardar(comentario);
        return new ResponseEntity<Comentario>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Comentario> deleteComentario(@PathVariable String id) {
        Comentario comentario = comentarioService.ConsultarId(id);
        if (comentario != null) {
            comentarioService.Eliminar(id);
            return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);
        } else {
            return new ResponseEntity<Comentario>(HttpStatus.NO_CONTENT);
        }
    }
}


