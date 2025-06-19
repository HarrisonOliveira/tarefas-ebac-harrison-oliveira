import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class ExemploLambda {
    public static void main(String[] args) {

        // Lambda utilizando IntBinaryOperator
        IntBinaryOperator intBinaryOperator = (int a, int b) -> {
            return a + b;
        };


        // Lambda utilizando BiFunction
        BiFunction<Integer, Integer, Integer> biFunctions = (Integer a, Integer b) -> {
            return a + b;
        };

        // Passando valores a função IntBinaryIperator e armazenando na variável var1 para ser utilizada.
        Integer var1 = intBinaryOperator.applyAsInt(5, 5);
        Integer var2 = biFunctions.apply(10, 10);

        System.out.println(var1);
        System.out.println(var2);


    }
}
