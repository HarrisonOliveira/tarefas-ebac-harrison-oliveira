package br.com.harrison;

import br.com.harrison.dao.ClienteDao;
import br.com.harrison.mock.ClienteDaoMock;
import br.com.harrison.service.ContratoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContratoServiceTest {

    @Test
    public void sucessoAoSalvarContrato(){
        Assertions.assertEquals("Sucesso no Mock", new ContratoService(new ClienteDaoMock()).salvar());
    }

    @Test
    public void espedoUmaExceptionAoTentarSalvar(){
        UnsupportedOperationException exception = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> new ContratoService(new ClienteDao()).salvar());
        Assertions.assertEquals("Não funciona sem configuração do Bando de Dados.", exception.getMessage());
    }
}
