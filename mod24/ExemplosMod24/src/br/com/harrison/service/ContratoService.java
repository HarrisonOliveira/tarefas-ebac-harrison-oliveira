package br.com.harrison.service;

import br.com.harrison.dao.ContratoDao;
import br.com.harrison.dao.IClienteDao;

public class ContratoService implements IContratoService{

    private final IClienteDao contratoDao;

        public ContratoService(IClienteDao contratoDao){
        this.contratoDao = contratoDao;
    }

    @Override
    public String salvar(){
        return contratoDao.salvar();
    }
}
