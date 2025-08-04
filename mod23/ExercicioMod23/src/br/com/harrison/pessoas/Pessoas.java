package br.com.harrison.pessoas;

import java.util.ArrayList;
import java.util.List;


public class Pessoas {
    List<String> feminino = new ArrayList<String>() {{
        add("Alice - Feminino");
        add("Bruna - Feminino");
        add("Carla - Feminino");
//        add("Harrison - Masculino");
    }};


    public List<String> getFeminino() {
        return feminino;
    }

    public List<String> setFeminino(String feminino) {
        if(feminino.contains("- F")){
            this.feminino.add(feminino);
        } else {
            System.out.println("Esta pessoa não é do Genero Feminino.");
        }
        return List.of();
    }
}
