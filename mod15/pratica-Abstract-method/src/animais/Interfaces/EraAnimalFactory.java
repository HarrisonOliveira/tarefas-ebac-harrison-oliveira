package animais.Interfaces;

import animais.Enums.AnimalEra;
import animais.Enums.AnimalType;
import animais.LandAnimal;
import animais.SkyAnimal;

public interface EraAnimalFactory {
    LandAnimal makeLandAnimal(AnimalEra era, AnimalType type, String name);
    SkyAnimal makeSkyAnimal(AnimalEra era, AnimalType type, String name);
}
