package main.java.ucb.guilherme.Application;

import main.java.ucb.guilherme.connection.ConexaoMysql;
import main.java.ucb.guilherme.dao.ProdutoDAO;
import main.java.ucb.guilherme.model.ProdutoModel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        main.java.ucb.guilherme.connection.ConexaoDB conexao = new ConexaoMysql();
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
