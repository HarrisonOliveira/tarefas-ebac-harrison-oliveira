package AtividadeMod17;

public class Carro {

    Long codigoCarro;
    MarcaCarro marcaCarro;
    String modeloCarro;

    public Carro(Long codigoCarro, MarcaCarro marcaCarro, String modeloCarro) {
        this.codigoCarro = codigoCarro;
        this.marcaCarro = marcaCarro;
        this.modeloCarro = modeloCarro;
    }

    public Long getCodigoCarro() {
        return codigoCarro;
    }

    public MarcaCarro getMarcaCarro() {
        return marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }
}
