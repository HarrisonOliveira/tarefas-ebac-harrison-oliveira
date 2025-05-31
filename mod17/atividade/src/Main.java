import AtividadeMod17.Carro;
import AtividadeMod17.Fabrica;
import AtividadeMod17.FabricaCarro;

public class Main {
    public static void main(String[] args) {
        Fabrica construirCarro = new FabricaCarro();

        construirCarro.criarCarro(1L, "1231231", "UNO");

        construirCarro.getListaCarros();
    }
}