package com.softtek.controlador;

import com.softtek.dto.ProductoDTO;
import com.softtek.excepciones.ExcepcionesPersonalizadasNoEncontrado;
import com.softtek.modelo.Producto;
import com.softtek.servicio.IProductoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {
    @Autowired
    private IProductoServicio servicio;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodos() {
        List<Producto> productosBBDD = servicio.consultaTodos();
        List<ProductoDTO> productosDto = new ArrayList<>();

        for (Producto producto: productosBBDD) {
            ProductoDTO pDto = new ProductoDTO();
            productosDto.add(pDto.castProductoADto(producto));
        }
        return new ResponseEntity<>(productosDto, HttpStatus.OK);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<ProductoDTO> obtenerUno(@PathVariable(name = "idProducto") int idProducto) {
        Producto p1 = servicio.consultaUno(idProducto);
        if (p1 == null) {
            throw new ExcepcionesPersonalizadasNoEncontrado("PRODUCTO NO ENCONTRADO " + idProducto);
        }
        return new ResponseEntity<>((new ProductoDTO()).castProductoADto(p1), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@Valid @RequestBody ProductoDTO p) {
        Producto p1 = p.castProducto();
        p1 = servicio.crear(p1);
        return new ResponseEntity<>(p.castProductoADto(p1), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductoDTO> updateProducto(@Valid @RequestBody ProductoDTO p) {
        Producto p1 = servicio.consultaUno(p.getIdProducto());
        if (p1 == null) {
            throw new ExcepcionesPersonalizadasNoEncontrado("Producto no encontrado " + p.getIdProducto());
        }
        return new ResponseEntity<>(p.castProductoADto(p1), HttpStatus.OK);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable(name = "idProducto") int idProducto) {
        Producto p = servicio.consultaUno(idProducto);
        if(p == null) {
            throw new ExcepcionesPersonalizadasNoEncontrado("PRODUCTO NO ENCONTRADO " + idProducto);
        }
        servicio.eliminar(idProducto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
