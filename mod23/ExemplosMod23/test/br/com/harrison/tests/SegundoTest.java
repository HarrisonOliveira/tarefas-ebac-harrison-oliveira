package br.com.harrison.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class SegundoTest {

    @Test
    public void segTeste(){
        String nome = "Harrison";
        Assertions.assertEquals("Harrison", nome);
    }

}
