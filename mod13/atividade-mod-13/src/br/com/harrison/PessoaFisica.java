package br.com.harrison;

public class PessoaFisica extends Pessoa implements IPessoaFisica{

    private String cpf;

    private String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void getPessoaFisica() {
        System.out.println("Informações de pessoa Fisica: ");
        System.out.println(STR."Nome: \{getNome()}, Sobrenome: \{getSobrenome()}, Documento: \{getCpf()}");
    }

    public void setPessoaFisica (String nome, String sobrenome, String cpf){
        setNome(nome);
        setSobrenome(sobrenome);
        setCpf(cpf);
    }
}
