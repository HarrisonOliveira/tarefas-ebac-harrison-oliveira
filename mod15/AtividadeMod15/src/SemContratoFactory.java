public class SemContratoFactory extends Factory{

    @Override
    Car retrieveCar(String requestedGrade) {
        if (requestedGrade.equals("B")){
            return new FiatCar(25, "Etanol", "Vermelho" );
        } else {
            return new HondaCar(50, "Etanol", "Azul" );
        }
    }
}
