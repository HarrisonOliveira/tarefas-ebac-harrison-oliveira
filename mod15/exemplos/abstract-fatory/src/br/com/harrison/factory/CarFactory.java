package br.com.harrison.factory;

public class CarFactory extends Factory{


    @Override
    Car retrieveCar(String requestedGrade) {

        if (requestedGrade.equals("A")) return new Volkswagen(100, "full", "Blue");
        if (requestedGrade.equals("B")) return new Toyota(150, "full", "blue");
        System.out.println("The request car was unfortunately not available");
        return null;
    }
}
