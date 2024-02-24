import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        int saldoDigitado = teclado.nextInt();

        System.out.println("Saldo digitado: " + saldoDigitado);



        Long saldoRecebido = Long.valueOf(saldoDigitado);

        System.out.println("Seu saldo agora é: " + saldoRecebido);
    }
}