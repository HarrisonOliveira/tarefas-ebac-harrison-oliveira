import br.com.harrison.IPessoaFisica;
import br.com.harrison.IPessoaJuridica;
import br.com.harrison.PessoaFisica;
import br.com.harrison.PessoaJuridica;

public class Main {
    public static void main(String[] args) {

        IPessoaJuridica pessoaJurica = new PessoaJuridica();
        IPessoaFisica pessoaFisica = new PessoaFisica();

        pessoaFisica.setPessoaFisica("Calos", "Braga", "123456789-00");
        pessoaFisica.getPessoaFisica();

        pessoaJurica.setPessoaJuridica("Maria", "Lima", "123456789/0001-00");
        pessoaJurica.getPessoajuridica();
    }
}