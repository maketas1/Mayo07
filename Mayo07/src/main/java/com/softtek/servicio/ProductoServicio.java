package com.softtek.servicio;

import com.softtek.modelo.Producto;
import com.softtek.repo.IGenericoRepository;
import com.softtek.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio extends CRUDImpl<Producto, Integer> implements IProductoServicio {

    @Autowired
    private IProductoRepo repo;

    @Override
    protected IGenericoRepository<Producto, Integer> getRepo() {
        return repo;
    }
}
