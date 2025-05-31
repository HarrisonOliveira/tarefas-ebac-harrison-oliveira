package AtividadeMod17;

import java.util.*;

public abstract class FabriaCarro implements ICarro {

    Map<Carro> listaCarros = new HashMap();

    List<Enum> listaMarcas = Arrays.asList(MarcaCarro.HONDA, MarcaCarro.TOYOTA, MarcaCarro.FIAT);

    @Override
    public Carro criarCarro(Long codigoCarro, MarcaCarro marcaCarro ,String modeloCarro) {
        if (listaMarcas.contains(marcaCarro)){
            Carro carro = new Carro(codigoCarro, marcaCarro, modeloCarro);
            return carro;
        }
        return null;
    }
}
