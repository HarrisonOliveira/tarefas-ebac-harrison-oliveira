package br.com.harrison.tests;

import br.com.harrison.cliente.TesteCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteClienteTest {

    @Test
    public void testandoCliente(){
        TesteCliente cliente = new TesteCliente();
        cliente.setNome("Harrison");

        Assertions.assertEquals("Harrison", cliente.getNome());

    }
}
