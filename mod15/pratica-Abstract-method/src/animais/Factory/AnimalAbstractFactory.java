package animais.Factory;

import animais.Animal;
import animais.Enums.AnimalEra;
import animais.Enums.AnimalType;

public class AnimalAbstractFactory {
    Animal animal;

    public Animal createAnimal( AnimalEra era,AnimalType type, String name){
        AnimalType typ = getFromConfiguration();

        switch (typ){
            case LAND -> animal = new MesozoicAnimalFactory().makeLandAnimal(era, type, name);
            case SKY -> animal = new CenozoicAnimalFactory().makeSkyAnimal(era, type, name);
        }
        return animal;
    }

    AnimalType getFromConfiguration(){
        return AnimalType.LAND;
    }
}
