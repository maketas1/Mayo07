package com.softtek.dto;

import com.softtek.modelo.Lugar;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LugarDTO {

    private int idLugar;

    @NotEmpty
    private String nombre;

    public Lugar castLugar() {
        Lugar l = new Lugar();
        l.setIdLugar(idLugar);
        l.setNombre(nombre);
        return l;
    }

    public LugarDTO castLugarADto(Lugar l) {
        idLugar = l.getIdLugar();
        nombre = l.getNombre();
        return this;
    }
}
