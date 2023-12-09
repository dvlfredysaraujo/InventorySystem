package com.zona.otaku.ZonaOtakuProjectv10.controller;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Cliente;
import com.zona.otaku.ZonaOtakuProjectv10.entity.Factura;
import com.zona.otaku.ZonaOtakuProjectv10.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {

    @Autowired
    IClienteService iClienteService;

    @GetMapping("/form/{id}")
    public String addFacturaG(@PathVariable (name = "id") Long idCliente, Model model, RedirectAttributes flash){
        Cliente cliente = iClienteService.findById(idCliente);

        if (cliente == null){
            flash.addFlashAttribute("error", "el cliente no existe en la base de datos");
            return "redirect:/clientes";
        }
        Factura factura = new Factura();
        factura.setCliente(cliente);

        model.addAttribute("factura", factura);
        return "factura/form";
    }
}
