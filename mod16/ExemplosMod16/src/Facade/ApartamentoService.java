package Facade;

public class ApartamentoService implements IApartamentoService{

    private void procuraApartamento() {
        System.out.println("Procurando um apartamento...");
    }

    private void virificaValor(Integer valorApartamento, Integer valorCliente) {
        System.out.println("Verificando se o valor é de acordo com o que o cliente deseja...");

        if(valorCliente >= valorApartamento){
            System.out.println("Valor do apartamento é compativel com valor Solicitado pelo cliente... \n" +
                    "Prosseguindo com a locação...");
        } else {
            System.out.println("Valor incompativel com valor proposto pelo cliente.");
        }

    }

    private void entraContatoCliente() {
        System.out.println("Entrando em contato com o Locador...");
    }

    private void validaAlocacao() {
        System.out.println("Fechando acordo com Locador...");
    }

    @Override
    public void alugarApartamento(Integer valorApartamento, Integer valorCliente ) {
        procuraApartamento();
        virificaValor(valorApartamento, valorCliente);
        entraContatoCliente();
        validaAlocacao();
    }

}
