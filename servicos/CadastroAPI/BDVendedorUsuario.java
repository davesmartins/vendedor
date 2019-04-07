package services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BDVendedorUsuario {

    public static Connection getConexao()
            throws ClassNotFoundException, SQLException {
        Class.forName("db.mysql.davesmartins.com.br");
        return DriverManager.getConnection("vendedor_usuario", "user_v5", " v1v2v3v4v5");
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (comando != null) {
                conexao.close();
            }
        } catch (SQLException ignored) {
        }
    }
        public static Long returnId(PreparedStatement comando) throws SQLException {
        System.out.println("I return the id of " + comando.getClass().getCanonicalName());
        try (ResultSet generatedKeys = comando.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            }
            return Long.MAX_VALUE;
        }
}
