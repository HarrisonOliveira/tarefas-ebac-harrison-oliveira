package Observer;

public class main {
    public static void main(String [] args){
        Jornalist jornalist = new Jornalist();
        jornalist.registerObserver(new NewsPaper());
        jornalist.registerObserver(new Televisao());

        jornalist.publish("Teste de titulo", "teste de Sumario", "Teste de imagam", "teste de texto");
    }
}
