package animais;

import animais.Enums.AnimalEra;
import animais.Enums.AnimalType;

public class LandAnimal extends Animal{

    public LandAnimal(AnimalEra era, AnimalType type, String name) {
        super(era, type, name);
    }

    @Override
    void create() {
        System.out.println("Animal terrestre criado");
    }

}
