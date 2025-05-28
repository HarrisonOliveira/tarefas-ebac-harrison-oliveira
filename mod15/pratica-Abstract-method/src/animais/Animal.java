package animais;

import animais.Enums.AnimalEra;
import animais.Enums.AnimalType;

public abstract class Animal {
    AnimalType type;
    AnimalEra era;
    String name;

   public Animal(AnimalEra era, AnimalType type, String name){
        this.type = type;
        this.era = era;
        this.name = name;
    }

    abstract void create();
}
