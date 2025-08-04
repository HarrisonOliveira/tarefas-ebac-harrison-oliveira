package org.example;

import org.w3c.dom.ls.LSInput;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nomes = sc.nextLine();

        String[] nomesPessoa = nomes.split(", ");

        List<String> listaNomes = new ArrayList<>(Arrays.asList(nomesPessoa));

        List<String> feminino = listaNomes.stream()
                .filter(mulheres -> mulheres.contains("- F"))
                .toList();

        System.out.println(feminino);
    }
}