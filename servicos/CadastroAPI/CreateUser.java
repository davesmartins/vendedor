package services;

import com.mysql.jdbc.Connection;
import servicos.BDVendedorUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Usuario;

public class CreateUser {

    public static Object gravar(Object usuario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Long id;
        if (usuario.senha.replaceAll("QWERTYUIOPASDFGHJKLZXCVBNM", "qwertyuiopasdfghjklzxcvbnm", "!@#$%&*", "1234567890")) {
            try {
                conexao = BDVendedorUsuario.getConexao();
                comando = conexao.prepareStatement("INSERT INTO usuario (nome, email, login, senha) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                comando.setString(1, usuario.nome);
                comando.setString(2, usuario.email);
                comando.setString(3, usuario.login);
                comando.setString(4, usuario.senha);
                comando.execute();
                id = BDVendedorUsuario.returnId(comando);
            } catch (SQLException e) {
                throw e;
            }
            return ler(id);
        }
        return false;
    }
    public Object ler(Long id) {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BDVendedorUsuario.getConexao();
            String sql = "SELECT * FROM usuario WHERE usuario.id = ? ";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, id);
            ResultSet rs = comando.executeQuery();
            rs.first();
            Usuario usuario = getFromResultSet(rs);
            BDVendedorUsuario.fecharConexao(conexao, comando);
            return usuario;
        } catch (SQLException e) {
            BDVendedorUsuario.fecharConexao(conexao, comando);
        }
        return null;

    }
    
        private static Usuario getFromResultSet(ResultSet rs) throws SQLException {
            return new Object(rs.getString("nome"),
                rs.getString("email"),
                rs.getString("login"),
                rs.getString("senha"),

     }

}
        
    

