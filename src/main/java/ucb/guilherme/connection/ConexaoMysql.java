package ucb.guilherme.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql implements ConexaoDB {
    String url = "jdbc:mysql://localhost:3306/ecommerce";
    String usuario = "root";
    String senha = "catolica";

    @Override
    public Connection obterConexao() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem sucedida");
            return connection;
        } catch (SQLException e){
            throw new SQLException("Erro ao conectar: " + e.getMessage());
        }
        // Não precisou do outro catch para o driver, pois está mantido pelo maven
    }
    @Override
    public void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
