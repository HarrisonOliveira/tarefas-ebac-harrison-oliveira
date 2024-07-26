package br.com.harrison.factory;

public class WithoutContractFactory extends Factory {


    @Override
    Car retrieveCar(String requestedGrade) {
        if (requestedGrade.equals("B")) return new Toyota(150, "Cheio", "Preto");
        return null;
    }
}
