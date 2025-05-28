public class CarFactory extends Factory{

    @Override
    Car retrieveCar(String requestedGrade){

        switch (requestedGrade){
            case "A":
                return new VolkswagemCar(100, "full", "blue");
            case "B":
                return new ToyotaCar(900, "fuel", "Branco");
            default:
                System.out.println("Infelizmente o carro requisitado não está disponivel.");
                return null;
        }
    }
}
