package br.com.harrison.factory;

public class ContractFactory extends Factory{
    @Override
    Car retrieveCar(String requestedGrade) {
        if(requestedGrade.equals("A")) return new Volkswagen(100, "Cheio", "Branco");
        return null;
    }
}
