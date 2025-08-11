package br.com.harrison.cliente;

public class Cliente {

    private String nome;
    private Long cpf;
    private Long telefone;
    private String logradouro;
    private Integer numeroResidencia;
    private String cidade;
    private String estado;

    public Cliente(String nome,
                   Long cpf,
                   Long telefone,
                   String logradouro,
                   Integer numeroResidencia,
                   String cidade,
                   String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numeroResidencia = numeroResidencia;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(Integer numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
