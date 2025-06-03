package ExemploAnnotations.PrimeiraAnnotation;


@PrimeiraAnnotation(value = "Oi", nome = {"Harrison", "Oliveira"}, numeroCasa = 230L, valores = 50.0)
public class ClasseComAnnotation {

    @PrimeiraAnnotation(value = "Olá", nome = {"Harrison", "Gessner"}, numeroCasa = 230L, valores = 500.0)
    private String nome;

    public String getNome() {
        return nome;
    }
}
