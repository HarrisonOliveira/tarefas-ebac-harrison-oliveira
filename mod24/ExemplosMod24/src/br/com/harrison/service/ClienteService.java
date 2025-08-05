package br.com.harrison.service;

import br.com.harrison.dao.ClienteDao;
import br.com.harrison.dao.IClienteDao;

public class ClienteService {

    private final IClienteDao clienteDao;

    public ClienteService (IClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    public String salvar() {
       return clienteDao.salvar();
    }
}
