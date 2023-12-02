package com.zona.otaku.ZonaOtakuProjectv10.controller;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Proveedor;
import com.zona.otaku.ZonaOtakuProjectv10.service.ProveedorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProveedorController {
    @Autowired
    ProveedorServiceImp proveedorServiceImp;

    @GetMapping("/proveedores")
    public String proveedores (Model model){
        List<Proveedor> proveedores = proveedorServiceImp.findAll();
//        model.addAttribute("titulo", "Listado de Proveedores");
        model.addAttribute("proveedores", proveedores);
        return "listaProveedores";
    }

    @GetMapping("/addProveedor")
    public String formularioProveedor(){
        return "formularioProveedor";
    }

    @PostMapping("/addProveedor")
    public String agregarProveedor(@ModelAttribute("proveedorFormulario") Proveedor proveedorFormulario){
        proveedorServiceImp.save(proveedorFormulario);
        return "redirect:/proveedores";
    }

    @GetMapping("/updateProveedor/{id}")
    public String formularioProveedor(@PathVariable(value = "id") Long idProveedor, Model model){
        Proveedor proveedor = proveedorServiceImp.finById(idProveedor);
        model.addAttribute("Proveedor", proveedor);
        return "editarProveedor";
    }

    @PostMapping("/updateProveedor")
    public String actualizarProveedor(@ModelAttribute("Proveedor") Proveedor proveedor){
        proveedorServiceImp.save(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/deleteProveedor/{id}")
    public String eliminarProveedor(@PathVariable(value = "id") Long idProveedor){
        proveedorServiceImp.delete(idProveedor);
        return "redirect:/proveedores";
    }

}
