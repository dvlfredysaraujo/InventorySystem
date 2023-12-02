package com.zona.otaku.ZonaOtakuProjectv10.service;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    public List<Categoria> findAll();
    public Categoria findById(Long idCategoria);
    public void save(Categoria categoria);
    public void deleteCategoria(Long idCategoria);
}
