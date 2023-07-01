package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/helpdesk";
        String username = "tavares";
        String password = "Tav1912@";

        try {
            // Registrar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, username, password);

            // Realizar operações no banco de dados...
            String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "Nome do Usuário");
                statement.setString(2, "email@example.com");
                statement.setString(3, "abc123");
                
                statement.executeUpdate();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            // Fechar a conexão
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer conexão com o banco de dados!");
            e.printStackTrace();
        }
    }
}