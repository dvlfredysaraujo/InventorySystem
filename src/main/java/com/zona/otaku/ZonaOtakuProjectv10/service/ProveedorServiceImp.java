package com.zona.otaku.ZonaOtakuProjectv10.service;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Proveedor;
import com.zona.otaku.ZonaOtakuProjectv10.repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImp implements IProveedorService{
    @Autowired
    private IProveedorRepository iProveedorRepository;
    @Override
    public List<Proveedor> findAll() {
        return iProveedorRepository.findAll();
    }

    @Override
    public Proveedor finById(Long idProveedor) {
        return iProveedorRepository.findById(idProveedor).orElse(null);
    }

    @Override
    public void save(Proveedor proveedor) {
        iProveedorRepository.save(proveedor);
    }

    @Override
    public void delete(Long idProveedor) {
        iProveedorRepository.deleteById(idProveedor);
    }
}
