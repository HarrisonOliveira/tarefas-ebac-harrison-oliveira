package br.com.harrison;
import br.com.harrison.dao.ClienteMapDAO;
import br.com.harrison.dao.IClienteDAO;
import br.com.harrison.domain.Cliente;

import javax.swing.*;


public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {

        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                """
                        Digite 1 para cadastro
                        Digite 2 para consultar
                        Digite 3 para exclusão
                        Digite 4 para alteração
                        Digite 5 para sair""",
                "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        while (!OpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    """
                           Opição Invalida!
                        Digite 1 para cadastro
                        Digite 2 para consultar
                        Digite 3 para exclusão
                        Digite 4 para alteração
                        Digite 5 para sair""",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (OpcaoValida(opcao)) {

            if (OpcaoSair(opcao)) {
                sair();
            }else if (Cadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome,Sobrenome,CPF",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (Consulta(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (Exclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome,Sobrenome,CPF",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para cadastro, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],Long.parseLong(dadosSeparados[2]));
        iClienteDAO.alterar(cliente);
    }

    private static void excluir(String dados) {
        iClienteDAO.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }


    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado com sucesso: " + cliente.toString(), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "ERRO",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],Long.parseLong(dadosSeparados[2]));
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado", "Erro",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean Exclusao(String opcao) {
        return Integer.parseInt(opcao) == 3;
    }

    private static boolean Consulta(String opcao) {
        return Integer.parseInt(opcao) == 2;
    }

    private static boolean Cadastro(String opcao) {
        return Integer.parseInt(opcao) == 1;
    }

    private static void sair() {
        String clientesCadastrados = "";
        for (Cliente cliente : iClienteDAO.consultarTodos()) {
            clientesCadastrados += cliente.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, "Clientes cadastrados: " + clientesCadastrados, "Até logo",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean OpcaoSair(String opcao) {
        return Integer.parseInt(opcao) == 5;
    }

    private static boolean OpcaoValida(String opcao) {
        return  Integer.parseInt(opcao) <= 5;
    }

}