//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        mediaDasNotas();
    }

    private static void mediaDasNotas() {
        int nota2 = 8;
        int nota1 = 5;
        int nota3 = 7;
        int nota4 = 9;

        int somaNotas = nota1 + nota2 + nota3 + nota4;
        int media = somaNotas / 4;

        System.out.println("Nota média é: " + media );
    }

}