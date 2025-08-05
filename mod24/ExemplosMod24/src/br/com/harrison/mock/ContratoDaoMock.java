package br.com.harrison.mock;

import br.com.harrison.dao.IClienteDao;
import br.com.harrison.dao.IContratoDao;
import br.com.harrison.service.IContratoService;

public class ContratoDaoMock implements IContratoDao {
    @Override
    public String salvar() {
        return "Sucesso no Mock";
    }
}
