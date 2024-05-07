package com.softtek.servicio;

import com.softtek.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoServicio {
    List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException;
    Producto obtenerUno(int id) throws SQLException, ClassNotFoundException;
    void alta(Producto p) throws SQLException, ClassNotFoundException;
    void eliminarUno(int id) throws SQLException, ClassNotFoundException;
    Producto updateUno(Producto p) throws SQLException, ClassNotFoundException;
}
