package Facade;

public class main {
    public static void main(String[] args){

        ApartamentoService apartamentoService = new ApartamentoService();

        apartamentoService.alugarApartamento(500, 600);

    }
}
