package CadastroProdutos;

public class Produto implements Persistence {

    private String nome;
    private Long codigoBarrasProduto;
    private Double precoCompraProduto;
    private Double custoEntradaProduto;
    private Double precoMedioProduto;
    private Double precoVendaProduto;
    private Double ICMSProduto;

    public Produto(String nome,
                   Long codigoBarrasProduto,
                   Double precoCompraProduto,
                   Double custoEntradaProduto,
                   Double precoMedioProduto,
                   Double precoVendaProduto,
                   Double ICMSProduto) {
        this.nome = nome;
        this.codigoBarrasProduto = codigoBarrasProduto;
        this.precoCompraProduto = precoCompraProduto;
        this.custoEntradaProduto = custoEntradaProduto;
        this.precoMedioProduto = precoMedioProduto;
        this.precoVendaProduto = precoVendaProduto;
        this.ICMSProduto = ICMSProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigoBarrasProduto() {
        return codigoBarrasProduto;
    }

    public void setCodigoBarrasProduto(Long codigoBarrasProduto) {
        this.codigoBarrasProduto = codigoBarrasProduto;
    }

    public Double getPrecoCompraProduto() {
        return precoCompraProduto;
    }

    public void setPrecoCompraProduto(Double precoCompraProduto) {
        this.precoCompraProduto = precoCompraProduto;
    }

    public Double getCustoEntradaProduto() {
        return custoEntradaProduto;
    }

    public void setCustoEntradaProduto(Double custoEntradaProduto) {
        this.custoEntradaProduto = custoEntradaProduto;
    }

    public Double getPrecoMedioProduto() {
        return precoMedioProduto;
    }

    public void setPrecoMedioProduto(Double precoMedioProduto) {
        this.precoMedioProduto = precoMedioProduto;
    }

    public Double getPrecoVendaProduto() {
        return precoVendaProduto;
    }

    public void setPrecoVendaProduto(Double precoVendaProduto) {
        this.precoVendaProduto = precoVendaProduto;
    }

    public Double getICMSProduto() {
        return ICMSProduto;
    }

    public void setICMSProduto(Double ICMSProduto) {
        this.ICMSProduto = ICMSProduto;
    }
}
