
import pokemon.Pokemon;

import java.sql.*;
import java.util.ArrayList;


public class Database {

    Connection connection;
    Statement statement;
    ResultSet result;
    PreparedStatement pst;

    static final String user = "root";
    static final String password = "root";
    static final String database = "Projeto";

    //String para conexão do banco de dados
    static final String url = "jdbc:mysql://localhost:3306/" + database;
    private boolean check = false;


    public void connect(){
        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Conexão concluida: " + connection);

        }catch (SQLException e){
            System.out.println("ERRO DE CONEXÃO" + e.getMessage());
        }
    }

    public boolean insertPokemon(Pokemon pokemon){
        connect();
        String sql = "INSERT INTO Pokemon(id, nome, tipo , atk, def, vida, lvl, shiny) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,pokemon.getId());      // concatena nome na primeira ? do comando
            pst.setString(2,pokemon.getNome());
            pst.setString(3,pokemon.getTipo());   // concatena nome na segunda ? do comando
            pst.setInt(4,pokemon.getAtk());
            pst.setInt(5,pokemon.getDef());
            pst.setInt(6,pokemon.getVida());
            pst.setInt(7,pokemon.getLvl());
            pst.setBoolean(8,pokemon.isShiny());
            pst.execute();                           // executa o comando
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    // ----------------------------BUSCANDO TODOS REGISTROS----------------------------
    public ArrayList<Pokemon> researchPokemon(){
        connect();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Pokemon pokemonTemp = new Pokemon(result.getInt("id"), result.getString("nome"), result.getString("tipo"),result.getInt("atk"),result.getInt("def"),result.getInt("vida"),result.getInt("lvl"),result.getBoolean("shiny"),result.getBoolean("possui")) {
                };
                pokemonTemp.setId(result.getInt("id"));
                System.out.println("ID = " + pokemonTemp.getId());
                System.out.println("NOME = " + pokemonTemp.getNome());
                System.out.println("TIPO = " + pokemonTemp.getTipo());
                System.out.println("ATAQUE = " + pokemonTemp.getAtk());
                System.out.println("DEFESA = " + pokemonTemp.getDef());
                System.out.println("VIDA = " + pokemonTemp.getVida());
                System.out.println("LEVEL = " + pokemonTemp.getLvl());
                if (pokemonTemp.isShiny()) {
                    System.out.println("O POKEMON É SHINY PARABENS ");
                }else
                    System.out.println("Não é shiny" );
                System.out.println("------------------------------");
                pokemons.add(pokemonTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return pokemons;
    }

    // ----------------------------BUSCANDO REGISTRO PELO CPF----------------------------
    public ArrayList<Pokemon> researchPokemonPossui(boolean possui){
        connect();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon WHERE possui = true";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Pokemon pokemonTemp = new Pokemon(result.getInt("id"), result.getString("nome"), result.getString("tipo"),result.getInt("atk"),result.getInt("def"),result.getInt("vida"),result.getInt("lvl"),result.getBoolean("shiny"),result.getBoolean("possui")) {
                };
                pokemonTemp.setId(result.getInt("id"));
                System.out.println("ID = " + pokemonTemp.getId());
                System.out.println("NOME = " + pokemonTemp.getNome());
                System.out.println("TIPO = " + pokemonTemp.getTipo());
                System.out.println("ATAQUE = " + pokemonTemp.getAtk());
                System.out.println("DEFESA = " + pokemonTemp.getDef());
                System.out.println("VIDA = " + pokemonTemp.getVida());
                System.out.println("LEVEL = " + pokemonTemp.getLvl());
                if (pokemonTemp.isShiny()) {
                    System.out.println("O POKEMON É SHINY PARABENS ");
                }else
                    System.out.println("Não é shiny" );
                System.out.println("------------------------------");
                pokemons.add(pokemonTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return pokemons;
    }

    // ----------------------------ATUALIZANDO NOME NO REGISTRO----------------------------
    public boolean updateUser(int id, String nome){
        connect();
        String sql = "UPDATE usuario SET nome=? WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    // ----------------------------EXCLUINDO REGISTRO----------------------------
    public boolean deleteUser(int id) {
        connect();
        String sql = "DELETE FROM usuario WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}


}
