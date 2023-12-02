package com.zona.otaku.ZonaOtakuProjectv10.service;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Categoria;
import com.zona.otaku.ZonaOtakuProjectv10.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaServiceImp implements ICategoriaService{

    @Autowired
    private ICategoriaRepository iCategoriaRepository;
    @Override
    public List<Categoria> findAll() {
        return iCategoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long idCategoria) {
        return iCategoriaRepository.findById(idCategoria).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
        iCategoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoria(Long idCategoria) {
        iCategoriaRepository.deleteById(idCategoria);
    }
}
