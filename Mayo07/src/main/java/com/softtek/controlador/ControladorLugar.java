package com.softtek.controlador;

import com.softtek.dto.LugarDTO;
import com.softtek.excepciones.ExcepcionesPersonalizadasNoEncontrado;
import com.softtek.modelo.Lugar;
import com.softtek.servicio.ILugarServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lugares")
public class ControladorLugar {
    @Autowired
    private ILugarServicio servicio;

    @GetMapping
    public ResponseEntity<List<LugarDTO>> obtenerTodos() {
        List<Lugar> lugaresBBDD = servicio.consultaTodos();
        List<LugarDTO> lugaresDto = new ArrayList<>();

        for (Lugar lugar: lugaresBBDD) {
            LugarDTO lDto = new LugarDTO();
            lugaresDto.add(lDto.castLugarADto(lugar));
        }
        return new ResponseEntity<>(lugaresDto, HttpStatus.OK);
    }

    @GetMapping("/{idLugar}")
    public ResponseEntity<LugarDTO> obtenerUno(@PathVariable(name = "idLugar") int idLugar) {
        Lugar l1 = servicio.consultaUno(idLugar);
        if (l1 == null) {
            throw new ExcepcionesPersonalizadasNoEncontrado("LUGAR NO ENCONTRADO " + idLugar);
        }
        return new ResponseEntity<>((new LugarDTO()).castLugarADto(l1), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LugarDTO> crearProducto(@Valid @RequestBody LugarDTO l) {
        Lugar l1 = l.castLugar();
        l1 = servicio.crear(l1);
        return new ResponseEntity<>(l.castLugarADto(l1), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LugarDTO> updateProducto(@Valid @RequestBody LugarDTO l) {
        Lugar l1 = servicio.consultaUno(l.getIdLugar());
        if (l1 == null) {
            throw new ExcepcionesPersonalizadasNoEncontrado("LUGAR NO ENCONTRADO " + l.getIdLugar());
        }
        return new ResponseEntity<>(l.castLugarADto(l1), HttpStatus.OK);
    }

    @DeleteMapping("/{idLugar}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable(name = "idLugar") int idLugar) {
        Lugar l = servicio.consultaUno(idLugar);
        if(l == null) {
            throw new ExcepcionesPersonalizadasNoEncontrado("LUGAR NO ENCONTRADO " + idLugar);
        }
        servicio.eliminar(idLugar);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
