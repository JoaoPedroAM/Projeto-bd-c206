package Database;
import Pokemon.Pokemon;

import java.sql.*;
import java.util.ArrayList;

public class PokemonDB extends Connection{

    // ------------------------- CRIAR POKEMON ----------------------------
    public boolean criarPokemon(Pokemon pokemon){
        connect();
        String sql = "INSERT INTO Pokemon(idpokemon, nome, tipo , local_idlocal) VALUES(?, ?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,pokemon.getId());      // concatena nome na primeira ? do comando
            pst.setString(2,pokemon.getNome());
            pst.setString(3,pokemon.getTipo());   // concatena nome na segunda ? do comando;
            pst.setInt(4,pokemon.getLocal_idlocal());
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

    // --------------------------BUSCANDO TODOS POKEMONS----------------------------
    public ArrayList<Pokemon> buscarPokemon(){
        connect();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Pokemon pokemonTemp = new Pokemon(result.getInt("id"), result.getString("nome"), result.getString("tipo"),result.getInt("local_idlocal")) {
                };
                pokemonTemp.setId(result.getInt("id"));
                System.out.println("ID = " + pokemonTemp.getId());
                System.out.println("NOME = " + pokemonTemp.getNome());
                System.out.println("TIPO = " + pokemonTemp.getTipo());
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

    // -------------------- BUSCAR POKEMON ID -----------
    public ArrayList<Pokemon> buscarPokemonID(int id){
        connect();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon WHERE idpokemon = " + id;
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Pokemon pokemonTemp = new Pokemon(result.getInt("idpokemon"), result.getString("nome"), result.getString("tipo"),result.getInt("local_idlocal")) {
                };
                pokemonTemp.setId(result.getInt("idpokemon"));
                System.out.println("ID = " + pokemonTemp.getId());
                System.out.println("NOME = " + pokemonTemp.getNome());
                System.out.println("TIPO = " + pokemonTemp.getTipo());
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

    // --------------------------ATUALIZANDO POKEMON----------------------------
    public boolean atualizarPokemon(int id, String nome){
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

    // --------------------------EXCLUINDO POKEMON----------------------------
    public boolean deletarPokemon(int id) {
        connect();
        String sql = "DELETE FROM pokemon WHERE idpokemon=?";
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
