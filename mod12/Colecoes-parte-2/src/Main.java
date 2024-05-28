import java.util.*;

/*
Nomes para o Input : Carlos - M, Alice - F, Maria - F, João - M
 */
public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String nomes = sc.nextLine();

        String[] nomesPessoas = nomes.split(", ");

        List<String> listaNomes = new ArrayList<>(Arrays.asList(nomesPessoas));

        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();


        Map<generoEnum, List<String>> pessoasGenero = new HashMap<>();


        for (String pessoa: listaNomes) {
            if (pessoa.contains("- M")) masculino.add(pessoa);
            else feminino.add(pessoa);

        }

        pessoasGenero.put(generoEnum.valueOf(generoEnum.MASCULINO.toString()), masculino);
        pessoasGenero.put(generoEnum.valueOf(generoEnum.FEMININO.toString()), feminino);



        System.out.println(pessoasGenero.get(generoEnum.MASCULINO));
        System.out.println(pessoasGenero.get(generoEnum.FEMININO));

    }

}