package com.zona.otaku.ZonaOtakuProjectv10.controller;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Producto;
import com.zona.otaku.ZonaOtakuProjectv10.service.CategoriaServiceImp;
import com.zona.otaku.ZonaOtakuProjectv10.service.IProductoService;
import com.zona.otaku.ZonaOtakuProjectv10.service.ProductoService;
import com.zona.otaku.ZonaOtakuProjectv10.service.ProveedorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @Autowired
    CategoriaServiceImp categoriaServiceImp;
    @Autowired
    ProveedorServiceImp proveedorServiceImp;

    @GetMapping(value = "/productos")
    public String listProductos(Model model){
        model.addAttribute("productos", productoService.findAll());
        return "listadoProductos";
    }

    @GetMapping("/addProductos")
    public String formProductos(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaServiceImp.findAll());
        model.addAttribute("proveedores", proveedorServiceImp.findAll());
        return "agregarProductos";
    }
    @PostMapping("/addProductos")
    public String agregarProducto(Producto producto){
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/updateProducto/{id}")
    public String formUpdateProducto(@PathVariable(name = "id") Long idProducto, Model model){
        Producto producto = productoService.findById(idProducto);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaServiceImp.findAll());
        model.addAttribute("proveedores", proveedorServiceImp.findAll());
        return "editarProducto";
    }

    @PostMapping("/updateProducto")
    public String updateProducto(Producto producto){
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducto(@PathVariable(name = "id") Long idProducto){
        productoService.delete(idProducto);
        return "redirect:/productos";
    }
}
