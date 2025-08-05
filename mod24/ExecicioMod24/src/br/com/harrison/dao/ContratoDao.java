package br.com.harrison.dao;

public class ContratoDao implements IContratoDao{
    @Override
    public String salvar() {
        return "Salvo com Sucesso";
    }

    @Override
    public String deletar() {
        return "Deletado com Sucesso";
    }

    @Override
    public String buscar() {
        return "Busca Concluida com Sucesso";
    }

    @Override
    public String atualizar() {
        return "Atualizado com Sucesso";
    }
}
