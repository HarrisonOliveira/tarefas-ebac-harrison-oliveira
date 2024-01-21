public class Cliente {
    private int codigo;
    private String nome;
    private String endereco;


    // Get e Set do Codigo
    public int getCodigo (){
        return codigo;
    }

    public void setCodigo (int codigo){
        this.codigo = codigo;
    }

    //Get e Set do nome
    public String getNome(){
        return nome;
    }
    public void setNome (String nome){
        this.nome = nome;
    }

    //Ger e Set do endereço
    private String getEndereco (){
        return endereco;
    }
    private void setEndereco (String endereco){
        this.endereco = endereco;
    }

}
