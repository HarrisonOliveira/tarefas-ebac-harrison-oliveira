package animais.Factory;

import animais.Animal;
import animais.Enums.AnimalEra;
import animais.Enums.AnimalType;
import animais.Interfaces.EraAnimalFactory;
import animais.LandAnimal;
import animais.SkyAnimal;

public class MesozoicAnimalFactory implements EraAnimalFactory {
    @Override
    public LandAnimal makeLandAnimal(AnimalEra era, AnimalType type, String name) {
        return new LandAnimal(era, type, name);
    }

    @Override
    public SkyAnimal makeSkyAnimal(AnimalEra era, AnimalType type, String name) {
        return new SkyAnimal(era, type, name);
    }

}
