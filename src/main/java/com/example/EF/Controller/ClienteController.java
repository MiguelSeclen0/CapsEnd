package com.example.EF.Controller;

import com.example.EF.Domain.Cliente;
import com.example.EF.Service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/cliente/")
@RestController
public class ClienteController {
    
    String carpeta= "Cliente/";
    
    @Autowired
    private ClienteService service;
    
    @GetMapping(value="/all")
    public List<Cliente> getAll(){
        return service.Listar();
    }
    
    
    @GetMapping("/")
    public String Mostrar(Model model)
    {
        List<Cliente> clientes = service.Listar();
        model.addAttribute("clientes", clientes);
        return carpeta+"lista";
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id, Model model)
    {
        service.Eliminar(id);
        
        return Mostrar(model);
        
    }
    
    @PostMapping("/registrar")
    public String Registrar(@RequestParam("nom") String nom,
                            @RequestParam("ape") String ape,
                            @RequestParam("dni") String dni,
                            @RequestParam("cel") String cel,
                            @RequestParam("ema") String ema,
                            @RequestParam("dir") String dir,
                            Model model)
    {
        Cliente p = new Cliente();
        
        p.setNombres(nom);
        p.setApellidos(ape);
        p.setDni(dni);
        p.setCelular(cel);
        p.setEmail(ema);
        p.setDireccion(dir);
        service.Guardar(p);
        
        return Mostrar(model);
    }
    
    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id") int id,
                            @RequestParam("nom") String nom,
                            @RequestParam("ape") String ape,
                            @RequestParam("dni") String dni,
                            @RequestParam("cel") String cel,
                            @RequestParam("ema") String ema,
                            @RequestParam("dir") String dir,
                            Model model)
    {
        Cliente p = new Cliente();
        p.setId(id);
        p.setNombres(nom);
        p.setApellidos(ape);
        p.setDni(dni);
        p.setCelular(cel);
        p.setEmail(ema);
        p.setDireccion(dir);
        
        service.Guardar(p);
        
        return Mostrar(model);
    
    }
    
    @PostMapping("/buscar")
    public String Buscar(@RequestParam("dato") String dato, Model model){
        List<Cliente> clientes = service.Buscar(dato);
        model.addAttribute("clientes", clientes);
        return carpeta+"lista";
    }
	@GetMapping("/orden_asc")
    public String OrdenarAsc(Model model){
        List<Cliente> clientes = service.OrdenarAsc();
        model.addAttribute("clientes", clientes);
        return carpeta+"lista";
    }
	@GetMapping("/orden_desc")
    public String OrdenarDesc(Model model){
        List<Cliente> clientes = service.OrdenarDesc();
        model.addAttribute("clientes", clientes);
        return carpeta+"lista";
    }
}


