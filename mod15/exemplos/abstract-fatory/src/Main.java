import br.com.harrison.factory.ContractFactory;
import br.com.harrison.factory.Custumer;
import br.com.harrison.factory.Factory;
import br.com.harrison.factory.WithoutContractFactory;

public class Main {
    public static void main(String[] args) {
        Custumer client = new Custumer("A", true);
        Factory factory = getFactory(client);
        factory.create(client.getGradeRequest());
    }

    private static Factory getFactory(Custumer client) {
        if (client.hasCompanyContract()) return new ContractFactory();
        return new WithoutContractFactory();
    }
}