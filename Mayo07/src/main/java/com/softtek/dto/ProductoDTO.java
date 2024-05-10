package com.softtek.dto;

import com.softtek.modelo.Producto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoDTO {
    private int idProducto;

    @NotEmpty
    private String nombreProducto;

    @NotNull
    private double precioUnitario;

    private int unidadesStock;

    public Producto castProducto () {
        Producto p = new Producto();
        p.setIdProducto(idProducto);
        p.setNombreProducto(nombreProducto);
        p.setPrecioUnitario(precioUnitario);
        p.setUnidadesStock(unidadesStock);
        return p;
    }

    public ProductoDTO castProductoADto(Producto p) {
        idProducto = p.getIdProducto();
        nombreProducto = p.getNombreProducto();
        precioUnitario = p.getPrecioUnitario();
        unidadesStock = p.getUnidadesStock();
        return this;
    }
}
