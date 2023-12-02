package com.zona.otaku.ZonaOtakuProjectv10.service;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();
    public Producto findById(Long idProducto);
    public void save(Producto producto);
    public void delete(Long idProducto);
}
