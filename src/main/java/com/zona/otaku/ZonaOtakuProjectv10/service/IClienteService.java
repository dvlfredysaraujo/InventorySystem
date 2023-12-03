package com.zona.otaku.ZonaOtakuProjectv10.service;

import com.zona.otaku.ZonaOtakuProjectv10.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
    public Cliente findById(Long idCliente);
    public void save(Cliente cliente);
    public void delete(Long idCliente);
}
