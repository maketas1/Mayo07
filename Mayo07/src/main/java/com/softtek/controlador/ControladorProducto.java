package com.softtek.controlador;

import com.softtek.modelo.Producto;
import com.softtek.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {
    @Autowired
    private IProductoServicio servicio;

    @GetMapping
    public Collection<Producto> obtenerTarea() throws SQLException, ClassNotFoundException {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{idProducto}")
    public Producto obtenerUno(@PathVariable int idProducto) throws SQLException, ClassNotFoundException {
        return servicio.obtenerUno(idProducto);
    }

    @PostMapping
    public void crearProducto(@RequestBody Producto p) throws SQLException, ClassNotFoundException {
        servicio.alta(p);
    }

    @PutMapping
    public Producto updateProducto(@RequestBody Producto p) throws SQLException, ClassNotFoundException {
        return servicio.updateUno(p);
    }

    @DeleteMapping("/{idProducto}")
    void eliminarProducto(@PathVariable int idProducto) throws SQLException, ClassNotFoundException {
        servicio.eliminarUno(idProducto);
    }
}
