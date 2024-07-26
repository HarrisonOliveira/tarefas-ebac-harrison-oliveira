package br.com.harrison.factory;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public abstract class Car {
    private int horsePower;
    private String fuelSourse;
    private String color;

    public Car (int horsePower, String fuelSourse, String color ){
        this.horsePower = horsePower;
        this.fuelSourse = fuelSourse;
        this.color = color;
    }

    public void startEngine(){
        System.out.println("The " + fuelSourse +
                "engine as been started, and is read to utilize" + horsePower + "horsepower.n");
    }

    public void clear(){
        System.out.println("Car as been cleaned");
    }

    public void mechanicCheck() {
        System.out.println("Car as been checked by the mechanic. Everything looks good!");
    }

    public void fuelCar() {
        System.out.println("Car is being fulled with " + fuelSourse.toLowerCase());
    }
}
