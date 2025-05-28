import animais.Animal;
import animais.Enums.AnimalEra;
import animais.Enums.AnimalType;
import animais.Factory.AnimalAbstractFactory;

public class Main {
    public static void main(String[] args) {
        new AnimalAbstractFactory().createAnimal(AnimalEra.CENOZOIC, AnimalType.SKY, "Voador");
    }
}