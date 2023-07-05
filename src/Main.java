package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

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

            Scanner scanner = new Scanner(System.in);

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();

            System.out.print("Status: ");
            String status = scanner.nextLine();

            System.out.print("Prioridade: ");
            String prioridade =  scanner.nextLine();

            System.out.print("Data da Criação: ");
            String dataCriacao = scanner.nextLine();

            System.out.print("ID do Usuário: ");
            int idUsuario = scanner.nextInt();
            scanner.nextLine();

            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, titulo);
                statement.setString(2, descricao);
                statement.setString(3, status);
                statement.setString(4, prioridade);
                statement.setString(5, dataCriacao);
                statement.setInt(6, idUsuario);

                statement.executeUpdate();
                
                System.out.println("Chamado Inserido com sucesso!");
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