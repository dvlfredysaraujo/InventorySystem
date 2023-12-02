package com.zona.otaku.ZonaOtakuProjectv10.service;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Proveedor;

import java.util.List;

public interface IProveedorService {
    public List<Proveedor> findAll();
    public Proveedor finById(Long idProveedor);
    public void save (Proveedor proveedor);
    public void delete(Long idProveedor);
}
