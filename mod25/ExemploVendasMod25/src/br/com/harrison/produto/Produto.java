package br.com.harrison.produto;


public class Produto {
    private int codigoInterno;
    private String descricao;
    private Long codigoBarras;
    private Double preco;
    private Integer quantidade;

    public Produto(int codigoInterno, String descricao, Long codigoBarras, Double preco, Integer quantidade) {
        this.codigoInterno = codigoInterno;
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    //Métodos Getters
    public Integer getCodigoInterno() {
        return codigoInterno;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setCodigoInterno(Integer codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    //Métodos Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigoBarras(Long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getCodigoBarras() {
        return codigoBarras;
    }
}
