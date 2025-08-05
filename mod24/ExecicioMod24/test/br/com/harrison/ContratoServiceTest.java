package br.com.harrison;

import br.com.harrison.dao.ContratoDao;
import br.com.harrison.service.ContratoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContratoServiceTest {

    @Test
    public void saltar(){
        Assertions.assertEquals("Salvo com Sucesso", new ContratoService(new ContratoDao()).salvar());
    }

    @Test
    public void buscar(){
        Assertions.assertEquals("Busca Concluida com Sucesso", new ContratoService(new ContratoDao()).buscar());
    }

    @Test
    public void deletar(){
        Assertions.assertEquals("Deletado com Sucesso", new ContratoService(new ContratoDao()).deletar());
    }

    @Test
    public void atualizar(){
        Assertions.assertEquals("Atualizado com Sucesso", new ContratoService(new ContratoDao()).atualizar());
    }
}
