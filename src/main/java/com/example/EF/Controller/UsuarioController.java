package com.example.EF.Controller;

import com.example.EF.Domain.Usuario;
import com.example.EF.Service.UsuarioService;

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
@RequestMapping(value = "/usuario/")
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping(value="/all")
    public List<Usuario> getAllUsuario(){
        return usuarioService.Listar();
    }
    
    @GetMapping(value ="/find/{id}")
    public Usuario findUsuario(@PathVariable String id){
        return usuarioService.ConsultarId(id);
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        Usuario obj = usuarioService.Guardar(usuario);
        return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable String id) {
        Usuario usuario = usuarioService.ConsultarId(id);
        if (usuario != null) {
            usuarioService.Eliminar(id);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        }
    }
}


