package br.com.harrison.produto;

import java.math.BigDecimal;

public class Produto {

    java.lang.Integer id;
    String nomeProduto;
    String eanProduto;
    BigDecimal valor;

    public java.lang.Integer getId() {
        return this.id;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public String getEanProduto() {
        return eanProduto;
    }

    public BigDecimal getValor() {
        return this.valor;
    }



    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setEanProduto(String eanProduto) {
        this.eanProduto = eanProduto;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", EanProduto='" + eanProduto + '\'' +
                ", valor=" + valor +
                '}';
    }
}
