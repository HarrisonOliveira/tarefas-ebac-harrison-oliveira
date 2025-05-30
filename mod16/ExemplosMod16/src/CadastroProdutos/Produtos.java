package CadastroProdutos;

public class Produtos {

    private String nome;
    private Long EAN;
    private Double precoCompraProduto;
    private Double custoEntradaProduto;
    private Double precoMedioProduto;
    private Double precoVendaProduto;
    private Double ICMSProduto;

    public Produtos(String nome,
                    Long EAN,
                    Double precoCompraProduto,
                    Double custoEntradaProduto,
                    Double precoMedioProduto,
                    Double precoVendaProduto,
                    Double ICMSProduto) {
        this.nome = nome;
        this.EAN = EAN;
        this.precoCompraProduto = precoCompraProduto;
        this.custoEntradaProduto = custoEntradaProduto;
        this.precoMedioProduto = precoMedioProduto;
        this.precoVendaProduto = precoVendaProduto;
        this.ICMSProduto = ICMSProduto;
    }
}
