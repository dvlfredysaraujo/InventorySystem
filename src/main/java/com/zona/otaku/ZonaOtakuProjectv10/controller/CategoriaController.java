package com.zona.otaku.ZonaOtakuProjectv10.controller;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Categoria;
import com.zona.otaku.ZonaOtakuProjectv10.service.CategoriaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaServiceImp categoriaServiceImp;

    @GetMapping("/categorias")
    public String listadoCategorias(Model model){
        model.addAttribute("categorias", categoriaServiceImp.findAll());
        return "listadoCategorias";
    }

    @GetMapping("/addCategoria")
    public String formularioCategoria(){
        return "agregarCategoria";
    }

    @PostMapping("/addCategoria")
    public String agregarCategoria (@ModelAttribute(value = "categoriaFormulario") Categoria categoria){
        categoriaServiceImp.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/updateCategoria/{id}")
    public String editarFormularioCategoria(@PathVariable(value = "id") Long idCategoria, Model model){
        Categoria categoria = categoriaServiceImp.findById(idCategoria);
        model.addAttribute("categoria", categoria);
        return "editarCategoria";
    }

    @PostMapping("/updateCategoria")
    public String editarCategoria(@ModelAttribute(value = "categoria") Categoria categoria){
        categoriaServiceImp.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/deleteCategoria/{id}")
    public String deleteCategoria(@PathVariable(value = "id") Long idCategoria){
        categoriaServiceImp.deleteCategoria(idCategoria);
        return "redirect:/categorias";
    }
}
