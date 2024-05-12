import java.util.Scanner;

//Tarefa realizada com a versão do JAVA 22


public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    byte contador = 1;
    float nota = 0f;



    do {
        System.out.println(STR."Insira sua \{contador}ª nota: ");
        nota = s.nextInt() + nota;
        contador++;
    }
    while (contador <= 4); {
        nota = nota / (contador - 1) ;
        if (nota >= 7) System.out.println(STR."Sua nota média foi de \{nota} pontos. Você foi aprovado, parabêns!");
        else if (nota >= 5) System.out.println(STR."Sua nota média foi de \{nota} pontos. Você está de recuperação.");
        else System.out.println(STR."Sua nota média foi de \{nota} pontos. Você está reprovado. ");
    }


}