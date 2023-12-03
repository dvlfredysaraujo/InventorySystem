package com.zona.otaku.ZonaOtakuProjectv10.controller;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Cliente;
import com.zona.otaku.ZonaOtakuProjectv10.service.ClienteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    @Autowired
    ClienteServiceImp clienteServiceImp;

    @GetMapping("/clientes")
    public String listClientes(Model model){
        model.addAttribute("clientes", clienteServiceImp.findAll());
        return "listadoClientes";
    }

    @GetMapping("clientes/add")
    public String addClientesG(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "agregarCliente";
    }

    @PostMapping("/clientes/add")
    public String addClientesP(Cliente cliente){
        clienteServiceImp.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/update/{id}")
    public String updateClienteG(@PathVariable(name = "id") Long idCliente, Model model){
        Cliente cliente = clienteServiceImp.findById(idCliente);
        model.addAttribute("cliente", cliente);
        return "editarCliente";
    }

    @PostMapping("/clientes/update")
    public String updateClienteP(Cliente cliente){
        clienteServiceImp.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/delete/{id}")
    public String deleteCliente(@PathVariable(name = "id") Long idCliente){
        clienteServiceImp.delete(idCliente);
        return "redirect:/clientes";
    }
    @GetMapping("/clientes/data/{id}")
    public String datosCliente(@PathVariable(name = "id") Long idCliente, Model model){
        Cliente cliente = clienteServiceImp.findById(idCliente);
        model.addAttribute("cliente", cliente);
        return "datosCliente";
    }
}
