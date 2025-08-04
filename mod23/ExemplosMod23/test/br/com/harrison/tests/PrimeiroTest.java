package br.com.harrison.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeiroTest {
    @Test
    public void Teste1(){
        String nome = "Harrison";
        Assertions.assertEquals("Harrison", nome);
    }

    @Test
    public void Teste2(){
        String nome = "Harrison";
        Assertions.assertNotEquals("Harrison1", nome);
    }
}
