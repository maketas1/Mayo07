package com.softtek.controlador;

import com.softtek.modelo.Lugar;
import com.softtek.modelo.Producto;
import com.softtek.servicio.ILugarServicio;
import com.softtek.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/lugares")
public class ControladorLugar {
    @Autowired
    private ILugarServicio servicio;

    @GetMapping
    public Collection<Lugar> obtenerTarea() throws SQLException, ClassNotFoundException {
        return servicio.consultaTodos();
    }

    @GetMapping("/{idLugar}")
    public Lugar obtenerUno(@PathVariable int idLugar) throws SQLException, ClassNotFoundException {
        return servicio.consultaUno(idLugar);
    }

    @PostMapping
    public Lugar crearProducto(@RequestBody Lugar l) throws SQLException, ClassNotFoundException {
        return servicio.crear(l);
    }

    @PutMapping
    public Lugar updateProducto(@RequestBody Lugar l) throws SQLException, ClassNotFoundException {
        return servicio.modificar(l);
    }

    @DeleteMapping("/{idLugar}")
    void eliminarProducto(@PathVariable int idLugar) throws SQLException, ClassNotFoundException {
        servicio.eliminar(idLugar);
    }
}
