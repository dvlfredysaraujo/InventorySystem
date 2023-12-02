package com.zona.otaku.ZonaOtakuProjectv10.service;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Producto;
import com.zona.otaku.ZonaOtakuProjectv10.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository iProductoRepository;
    @Override
    public List<Producto> findAll() {
        return iProductoRepository.findAll();
    }

    @Override
    public Producto findById(Long idProducto) {
        return iProductoRepository.findById(idProducto).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        iProductoRepository.save(producto);
    }

    @Override
    public void delete(Long idProducto) {
        iProductoRepository.deleteById(idProducto);
    }
}
