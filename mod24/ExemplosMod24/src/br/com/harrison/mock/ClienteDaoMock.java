package br.com.harrison.mock;

import br.com.harrison.dao.IClienteDao;

public class ClienteDaoMock implements IClienteDao {
    @Override
    public String salvar() {
        return "Sucesso no Mock";
    }
}
