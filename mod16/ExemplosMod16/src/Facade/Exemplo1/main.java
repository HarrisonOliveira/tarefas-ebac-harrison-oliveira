package Facade.Exemplo1;

public class main {
    public static void main(String[] args){
        IApartamentoService apartamentoService = new ApartamentoService();
        apartamentoService.alugarApartamento(500, 600);

    }
}
