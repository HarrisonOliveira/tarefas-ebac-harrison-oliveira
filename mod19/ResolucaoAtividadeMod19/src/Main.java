//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Class<Cliente> clienteClass = Cliente.class;
        if (clienteClass.isAnnotationPresent(Tabela.class)) {
            Tabela anotacaoTabela = clienteClass.getAnnotation(Tabela.class);
            System.out.println("Nome da Tabela: " + anotacaoTabela.getNomeTabela());
        } else {
            System.out.println("A anotação @Tabela não está presente nesta classe.");
        }
    }
}