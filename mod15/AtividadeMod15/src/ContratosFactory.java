public class ContratosFactory extends Factory{
    @Override
    Car retrieveCar(String requestedGrade) {
        if (requestedGrade.equals("A")){
            return new ToyotaCar(100, "Gasolina", "Branco" );
        } else {
            return new HondaCar(50, "Gasolina", "Azul" );
        }

    }
}
