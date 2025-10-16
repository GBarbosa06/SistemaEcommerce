package ucb.guilherme.Application;

import ucb.guilherme.connection.ConexaoMysql;
import ucb.guilherme.dao.ProdutoDAO;
import ucb.guilherme.model.ProdutoModel;
import ucb.guilherme.connection.ConexaoDB;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConexaoDB conexao = new ConexaoMysql();
        ProdutoDAO produtoDAO = new ProdutoDAO(conexao);

        List<ProdutoModel> produtos = produtoDAO.listarTodos();

        for (ProdutoModel p : produtos) {
            System.out.println(p.getId() + " - " + p.getNome() + " | R$ " + p.getPreco());
            System.out.println("  " + p.getDescricao());
            System.out.println("  Estoque: " + p.getQuantidadeEstoque());
            System.out.println("-----------------------------------");
        }
    }
}
