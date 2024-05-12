import java.util.Scanner;

//Tarefa realizada com a versão do JAVA 22


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite a sua primeira notaz: ");
        byte nota1 = s.nextByte();

        System.out.println("Digite a sua quinta nota: ");
        byte nota2 = s.nextByte();

        System.out.println("Digite a sua terceira nota: ");
        byte nota3 = s.nextByte();

        System.out.println("Digite a sua quarta nota: ");
        byte nota4 = s.nextByte();

        int nota = (nota1 + nota2 + nota3 + nota4) / 4;

        if (nota >= 7) System.out.println(STR."Sua nota média foi \{nota}. Você foi aprovado, parabêns!");
        else if (nota >= 5) System.out.println(STR."Sua nota média foi \{nota}. Você está de recuperação." );
        else System.out.println(STR."Sua nota média foi \{nota}. Você está reprovado. ");
    }
}