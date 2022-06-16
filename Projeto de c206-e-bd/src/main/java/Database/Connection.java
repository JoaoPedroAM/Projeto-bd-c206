package Database;

import java.sql.*;

public abstract class Connection {

    java.sql.Connection connection;   // objeto responsável por fazer a conexão com o servidor do MySQL
    Statement statement;     // objeto responsável por preparar consultas "SELECT"
    ResultSet result;        // objeto responsável por executar consultas "SELECT"
    PreparedStatement pst;   // objeto responsável por preparar querys de manipulação dinâmicas (INSERT, UPDATE, DELETE)

    static final String user = "root";
    static final String password = "Lfcf210102";
    static final String database = "Projeto";

    //String para conexão do banco de dados
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    boolean check = false;


    public void connect(){
        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Conexão concluida: " + connection);

        }catch (SQLException e){
            System.out.println("ERRO DE CONEXÃO: " + e.getMessage());
        }
    }

}