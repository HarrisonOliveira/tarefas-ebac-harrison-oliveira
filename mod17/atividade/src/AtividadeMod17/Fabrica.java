package AtividadeMod17;

import java.util.*;

public abstract class Fabrica implements ICarro {

    Map<Long, Carro> listaCarros = new HashMap<>();

    @Override
    public void criarCarro(Long codigoCarro, String marcaCarro, String modeloCarro) {
            if (validadorEnum(String.valueOf(marcaCarro))){
                Carro novoCarro = new Carro(codigoCarro, marcaCarro, modeloCarro);
                listaCarros.put(codigoCarro, novoCarro);
            }
    }


    public void getListaCarros() {
        for (Carro lista : listaCarros.values()){
            System.out.println("Codigo do carro: " + lista.codigoCarro);
            System.out.println("Marca do carro: " +lista.marcaCarro);
            System.out.println("Modelo do carro: " +lista.modeloCarro);
        }
    }

    private Boolean validadorEnum(String marcaCarro) {
//        String porMaiuscula = marcaCarro.toUpperCase();

        if (java.util.Arrays.stream(MarcaCarro.values())
                .map(MarcaCarro::name)
                .toList()
                .contains(marcaCarro.toUpperCase())) {
            System.out.println("Marca encontrada. Prosseguindo com a construção do carro.");
            return true;
        }
        System.out.println("Marca de carro não encontrada.");
        return false;
    }

    @Override
    public String toString() {
        return "Fabrica{" +
                "listaCarros=" + listaCarros +
                '}';
    }
}
