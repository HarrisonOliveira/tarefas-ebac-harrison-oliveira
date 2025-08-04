import br.com.harrison.pessoas.Pessoas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class PessoaTesteTest {
  Pessoas pessoa = new Pessoas();

  @Test
    public void testePessoa(){

    List<String> mulheres = pessoa.getFeminino();

    boolean isMulheres = mulheres.stream()
            .allMatch(nome -> nome.contains("- F"));

    Assertions.assertTrue(isMulheres, "A lista tem pessoas que não possue o genero feminino");

    System.out.println("Todos nesta linda são so genero Feminino. " + mulheres);
  }
}