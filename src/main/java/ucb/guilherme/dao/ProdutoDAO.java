package ucb.guilherme.dao;

import ucb.guilherme.connection.ConexaoDB;
import ucb.guilherme.model.ProdutoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final ConexaoDB conexaoDB;

    public ProdutoDAO(ConexaoDB conexaoDB) {
        this.conexaoDB = conexaoDB;
    }

    public List<ProdutoModel> listarTodos() {
        List<ProdutoModel> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        Connection conn = null;
        try {
            conn = conexaoDB.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoModel p = new ProdutoModel();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                produtos.add(p);
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexaoDB.fecharConexao(conn);
        }

        return produtos;
    }
}
