package TemplateMethod;

public abstract class Trabalhador {

    public void executarRotina(){

        iniciarRotina();
        levantar();
        tomaCafe();
        trabalhar();

    }

    private void tomaCafe() {
        System.out.println("Tomando café");
    }

    private void iniciarRotina(){
        System.out.println("A Rotina foi iniciada");
    }

    private void levantar(){
        System.out.println("Levantando da cama.");
    }

    protected abstract void trabalhar();

}
