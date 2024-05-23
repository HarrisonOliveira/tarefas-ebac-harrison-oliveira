import java.util.*;


public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String nomes = sc.nextLine();

        String[] nomesPessoas = nomes.split(", ");

        List<String> listaNomes = new ArrayList<>(Arrays.asList(nomesPessoas));

        Collections.sort(listaNomes);
        System.out.println(listaNomes);
    }

}