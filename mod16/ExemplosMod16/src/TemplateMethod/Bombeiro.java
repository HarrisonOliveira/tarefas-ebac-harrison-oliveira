package TemplateMethod;

public class Bombeiro extends Trabalhador
{
    @Override
    protected void trabalhar() {
        System.out.println("O bombeiro está apagando o fogo.");
    }

}
