package br.com.harrison.service;

import br.com.harrison.dao.ContratoDao;

public class ContratoService implements IContratoService{

    private ContratoDao contratoDao;

    public ContratoService (ContratoDao contratoDao){
        this.contratoDao = contratoDao;
    }


    @Override
    public String salvar() {
        return contratoDao.salvar();
    }

    @Override
    public String buscar() {
        return contratoDao.buscar();
    }

    @Override
    public String deletar() {
       return contratoDao.deletar();
    }

    @Override
    public String atualizar() {
        return contratoDao.atualizar();
    }
}
