package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

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

            // Leitura dos dados do usuário

            Scanner scanner = new Scanner(System.in);

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();

            System.out.print("Status: ");
            String status = scanner.nextLine();

            System.out.print("Prioridade: ");
            String prioridade =  scanner.nextLine();

            //obtenção da da data atual
            Date dataAtual = new Date();
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");

            String dataCriacao = formatoData.format((dataAtual));

            System.out.print("Data da Criação: " + dataAtual);
           
            System.out.print("ID do Usuário: ");
            int idUsuario;
            try{
                idUsuario = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Entrada Inválida. Insira um número válido de usuário.");
                scanner.nextLine();
                return;
            }

            //inserção dos dados obtidos no banco de dados, na tabela de chamados

            String sqlChamados = "INSERT INTO chamados (titulo, descricao, status, prioridade, data_criacao, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
            
            try(PreparedStatement statement = connection.prepareStatement(sqlChamados)){
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