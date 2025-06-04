


public class Cliente {

    @Tabela(tabelaCliente = "getTabelaCliente")
    public void getTabelaCliente(){
        System.out.println("Tabela de clientes foi passada");
    }

}

