package com.example.EF.Controller;

import com.example.EF.Domain.VentaDetalle;
import com.example.EF.Domain.Producto;
import com.example.EF.Domain.Venta;
import com.example.EF.Domain.Cliente;
import com.example.EF.Service.ClienteService;
import com.example.EF.Service.ProductoService;
import com.example.EF.Service.VentaDetalleService;
import com.example.EF.Service.VentaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/ventadetalle")
@Controller
public class VentaDetalleController {
    
    ArrayList<VentaDetalle> listaVD = new ArrayList();
    
    String carpeta= "Venta/";
    
    @Autowired
    private VentaDetalleService serviceVD;
    
    @Autowired
    private VentaService serviceV;
    
    @Autowired
    private ProductoService serviceP;
    
    @Autowired
    private ClienteService serviceC;
    int idP;
    
    @PostMapping("/actualizarIni")
    public String ActualizarIni(@RequestParam("id") int id,
                            Model model)
    {
        listaVD.clear();
        idP=id;
        
        if(serviceVD.ConsultarId(idP).isEmpty()){
            model.addAttribute("ventadetalles", listaVD);
        }else{
            List<VentaDetalle> ventadetalles = serviceVD.ConsultarId(id);
            listaVD.addAll(ventadetalles);
        }
        return Mostrar(model);
    }
    
    @GetMapping("/")
    public String Mostrar(Model model)
    {
        model.addAttribute("DatoVC", serviceV.BuscarId(idP));
        List<Venta> ventas = serviceV.Listar();
        model.addAttribute("ventas", ventas);
        
        List<Producto> productos = serviceP.Listar();
        model.addAttribute("productos", serviceP.ProductoDisponible());
        
        List<Cliente> clientes = serviceC.Listar();
        model.addAttribute("clientes", clientes);
        
        model.addAttribute("ventadetalles", listaVD);
        return carpeta+"listaD";
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id, Model model)
    {
        for (int i = 0; i < listaVD.size(); i++) 
        {
            if (i==id-1) 
            {
                listaVD.remove(i);
            }
        }
        return Mostrar(model);
        
    }
    
    @PostMapping("/registrar")
    public String Registrar(@RequestParam("pro") Producto pro,
                            @RequestParam("can") int can,
                            Model model)
    {
        VentaDetalle p = new VentaDetalle();
        
        p.setProducto(pro);
        p.setVenta(serviceV.BuscarId(idP));
        p.setCantidad(can);
        p.setPrecio(pro.getPrecio());
        listaVD.add(p);
        
        return Mostrar(model);
    }
    
    @GetMapping("/actualizar")
    public String Actualizar(Model model) {
        
        if (serviceVD.ConsultarId(idP).isEmpty()) {
            for (int i = 0; i < listaVD.size(); i++) {
                serviceVD.Guardar(listaVD.get(i));
            }
        }

        List<Venta> ventas = serviceV.Listar();
        model.addAttribute("ventas", ventas);

        List<Cliente> clientes = serviceC.Listar();
        model.addAttribute("clientes", clientes);
        return carpeta + "lista";
    }
    
}


