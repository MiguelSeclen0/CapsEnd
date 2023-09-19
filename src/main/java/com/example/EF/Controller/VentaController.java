package com.example.EF.Controller;

import com.example.EF.Domain.Venta;
import com.example.EF.Domain.Cliente;
import com.example.EF.Service.ClienteService;
import com.example.EF.Service.ProductoService;
import com.example.EF.Service.VentaDetalleService;
import com.example.EF.Service.VentaService;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/venta")
@Controller
public class VentaController {

    String carpeta = "Venta/";

    @Autowired
    private VentaService serviceV;

    @Autowired
    private ClienteService serviceC;

    @Autowired
    private ProductoService serviceP;

    @Autowired
    private VentaDetalleService serviceVD;

    @GetMapping("/")
    public String Mostrar(Model model) {
        List<Venta> ventas = serviceV.Listar();
        model.addAttribute("ventas", ventas);

        List<Cliente> clientes = serviceC.Listar();
        model.addAttribute("clientes", clientes);
        
        //pie
        Map<String, Integer> graphData = new TreeMap<>();
        for (int i = 0; i < clientes.size(); i++) {
            int id = clientes.get(i).getId();
            String nom = clientes.get(i).getNombres() + "" + clientes.get(i).getApellidos();
            List<Venta> venta = serviceV.PieData(id);
            int cant = venta.size();
            graphData.put(nom, cant);
        }
        model.addAttribute("graphData", graphData);
        return carpeta + "lista";
    }

    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id, Model model) {
        if (!serviceVD.ConsultarId(id).isEmpty()) {
            for (int i = 0; i < serviceVD.ConsultarId(id).size() + 1; i++) {
                if (serviceVD.ConsultarId(id).get(i).getVenta().getId() == id) {
                    serviceVD.Eliminar(serviceVD.ConsultarId(id).get(i).getId());
                }
            }
        }

        serviceV.Eliminar(id);
        return Mostrar(model);

    }

    @PostMapping("/registrar")
    public String Registrar(@RequestParam("cli") Cliente cli,
            @RequestParam("des") String des,
            Model model) throws ParseException {
        Date ahora = new Date();

        SimpleDateFormat formateador_fecha = new SimpleDateFormat("yyyy-dd-MM");
        String fecha_text = formateador_fecha.format(ahora);
        Date fecha = formateador_fecha.parse(fecha_text);
        SimpleDateFormat formateador_hora = new SimpleDateFormat("HH:mm:ss");
        String hora_text = formateador_hora.format(ahora);
        Time hora = Time.valueOf(hora_text);
        Venta p = new Venta();

        p.setCliente(cli);
        p.setDescripcion(des);
        p.setFecha(fecha);
        p.setHora(hora);
        serviceV.Guardar(p);
        return Mostrar(model);
    }

    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id") int id,
            @RequestParam("cli") Cliente cli,
            @RequestParam("des") String des,
            Model model) throws ParseException {
        Date ahora = new Date();

        SimpleDateFormat formateador_fecha = new SimpleDateFormat("yyyy-dd-MM");
        String fecha_text = formateador_fecha.format(ahora);
        Date fecha = formateador_fecha.parse(fecha_text);
        SimpleDateFormat formateador_hora = new SimpleDateFormat("HH:mm:ss");
        String hora_text = formateador_hora.format(ahora);
        Time hora = Time.valueOf(hora_text);

        Venta p = new Venta();
        p.setId(id);
        p.setCliente(cli);
        p.setDescripcion(des);
        p.setFecha(fecha);
        p.setHora(hora);

        serviceV.Guardar(p);
        return Mostrar(model);
    }

    @PostMapping("/buscar")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Venta> ventas = serviceV.Buscar(dato);
        model.addAttribute("ventas", ventas);

        List<Cliente> clientes = serviceC.Listar();
        model.addAttribute("clientes", clientes);
        return carpeta + "lista";
    }

    @GetMapping("/orden_asc")
    public String OrdenarAsc(Model model) {
        List<Venta> ventas = serviceV.OrdenarAsc();
        model.addAttribute("ventas", ventas);

        List<Cliente> clientes = serviceC.Listar();
        model.addAttribute("clientes", clientes);
        return carpeta + "lista";
    }

    @GetMapping("/orden_desc")
    public String OrdenarDesc(Model model) {
        List<Venta> ventas = serviceV.OrdenarDesc();
        model.addAttribute("ventas", ventas);

        List<Cliente> clientes = serviceC.Listar();
        model.addAttribute("clientes", clientes);
        return carpeta + "lista";
    }
}
