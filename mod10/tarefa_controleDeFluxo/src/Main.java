import java.util.Scanner;

//Tarefa realizada com a versão do JAVA 22


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a sua nota: ");

        int nota = s.nextInt();

        if (nota >= 7) System.out.println("Você foi aprovado, parabêns!");
        else if (nota >= 5) System.out.println("Você está de recuperação.");
        else System.out.println("Você está reprovado. ");
    }
}