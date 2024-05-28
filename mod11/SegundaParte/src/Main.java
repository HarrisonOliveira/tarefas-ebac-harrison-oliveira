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


        for (String genero: listaNomes) {
            if (genero.contains("- M")) masculino.add(genero);
            else feminino.add(genero);
        }
        
        Collections.sort(masculino);
        Collections.sort(feminino);
        System.out.println(masculino);
        System.out.println(feminino);
    }

}