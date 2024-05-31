package br.com.harrison;

public class PessoaJuridica extends Pessoa implements IPessoaJuridica {

    private String cnpj;

    private String getCnpj() {
        return cnpj;
    }

    private void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public  void getPessoajuridica(){
        System.out.println("Informações Pessoa Jurídica:");
        System.out.println(STR."Nome: \{getNome()}, Sobrenome: \{getSobrenome()}, Documento: \{getCnpj()}");
    }

    @Override
    public void setPessoaJuridica (String nome, String sobrenome, String cnpj){
        setNome(nome);
        setSobrenome(sobrenome);
        setCnpj(cnpj);
    }

}
