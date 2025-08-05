package br.com.harrison;

import br.com.harrison.dao.ClienteDao;
import br.com.harrison.mock.ClienteDaoMock;
import br.com.harrison.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ClienteServiceTest {

    @Test
    public void esperadoSucessoNoMedotoSalvar(){
        ClienteService clienteService = new ClienteService(new ClienteDaoMock());
        Assertions.assertEquals("Sucesso no Mock", clienteService.salvar());
    }

    @Test
    public void esperadoRetornoDiferendoDoMetodoSalvar(){
        ClienteService clienteService = new ClienteService(new ClienteDaoMock());
        Assertions.assertNotEquals("Não teve sucesso no Mock", clienteService.salvar());
    }

    @Test
    public void esperadoUmaException(){
        UnsupportedOperationException exception = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> new ClienteDao().salvar());
        Assertions.assertEquals("Não funciona sem configuração do Bando de Dados.", exception.getMessage());
    }
}