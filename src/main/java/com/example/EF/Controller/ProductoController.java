package com.example.EF.Controller;

import com.example.EF.Domain.Producto;
import com.example.EF.Domain.Categoria;
import com.example.EF.Service.CategoriaService;
import com.example.EF.Service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/producto")
@Controller
public class ProductoController {
    
    String carpeta= "Producto/";
    
    @Autowired
    private ProductoService serviceP;
    
    @Autowired
    private CategoriaService serviceC;
    
    @GetMapping("/")
    public String Mostrar(Model model)
    {
        List<Producto> productos = serviceP.Listar();
        model.addAttribute("productos", productos);
        
        List<Categoria> categorias = serviceC.Listar();
        model.addAttribute("categorias", categorias);
        return carpeta+"lista";
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id, Model model)
    {
        serviceP.Eliminar(id);
        
        return Mostrar(model);
        
    }
    
    @PostMapping("/registrar")
    public String Registrar(@RequestParam("nom") String nom,
                            @RequestParam("cat") Categoria cat,
                            @RequestParam("des") String des,
                            @RequestParam("pre") float pre,
                            @RequestParam("can") int can,
                            Model model)
    {
        Producto p = new Producto();
        
        p.setNombre(nom);
        p.setCategoria(cat);
        p.setDescripcion(des);
        p.setPrecio(pre);
        p.setCantidad(can);
        serviceP.Guardar(p);
        
        return Mostrar(model);
    }
    
    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id") int id,
                            @RequestParam("nom") String nom,
                            @RequestParam("cat") Categoria cat,
                            @RequestParam("des") String des,
                            @RequestParam("pre") float pre,
                            @RequestParam("can") int can,
                            Model model)
    {
        Producto p = new Producto();
        p.setId(id);
        p.setNombre(nom);
        p.setCategoria(cat);
        p.setDescripcion(des);
        p.setPrecio(pre);
        p.setCantidad(can);
        serviceP.Guardar(p);
        
        return Mostrar(model);
    
    }
    
    @PostMapping("/buscar")
    public String Buscar(@RequestParam("dato") String dato, Model model){
        List<Producto> productos = serviceP.Buscar(dato);
        model.addAttribute("productos", productos);
        
        List<Categoria> categorias = serviceC.Listar();
        model.addAttribute("categorias", categorias);
        return carpeta+"lista";
    }
	@GetMapping("/orden_asc")
    public String OrdenarAsc(Model model){
        List<Producto> productos = serviceP.OrdenarAsc();
        model.addAttribute("productos", productos);
        
        List<Categoria> categorias = serviceC.Listar();
        model.addAttribute("categorias", categorias);
        return carpeta+"lista";
    }
	@GetMapping("/orden_desc")
    public String OrdenarDesc(Model model){
        List<Producto> productos = serviceP.OrdenarDesc();
        model.addAttribute("productos", productos);
        
        List<Categoria> categorias = serviceC.Listar();
        model.addAttribute("categorias", categorias);
        return carpeta+"lista";
    }
}


