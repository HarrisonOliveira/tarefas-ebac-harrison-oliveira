public abstract class Car {

    private int horsePower;
    private String fuelSource;
    private String color;

    public Car(int horsePower, String fuelSource, String color) {
        this.horsePower = horsePower;
        this.fuelSource = fuelSource;
        this.color = color;
    }

    public void startEngine(){
        System.out.println("Carro ligou com sucesso e pornto para usar os " + horsePower +  " cavalos de potencia para ser usado %n");
    }
    public void clear() {
        System.out.println("O carro está limpo e com a cor" + color.toLowerCase() +  "radiante e pronto para uso. %n");
    }
    public void mechanicCheck(){
        System.out.println("O carro está com revisão em dia e pronto para rodar. %n");
    }

    public void fuelCar(){
        System.out.println("O carro está com o tante completamente cheio de" + fuelSource.toLowerCase());
    }
}
