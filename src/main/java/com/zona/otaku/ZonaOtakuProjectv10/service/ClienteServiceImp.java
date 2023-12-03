package com.zona.otaku.ZonaOtakuProjectv10.service;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Cliente;
import com.zona.otaku.ZonaOtakuProjectv10.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements IClienteService{
    @Autowired
    IClienteRepository clienteRepository;
    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}
