package Database;
import Pokemon.Pokemon;
import Cidade.Local;

import java.sql.*;
import java.util.ArrayList;

public class LocalDB extends Connection {

    // ----------------------------- CRIAR CIDADE ----------------------------
    public boolean criarCidade(Local local){
        connect();
        String sql = "INSERT INTO Local(idlocal, nome) VALUES(?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,local.getIdlocal());      // concatena nome na primeira ? do comando
            pst.setString(2,local.getNome());
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

    // -------------------- BUSCA DE POKEMONS EM LOCAIS ESPECIFICOS-----------
    public ArrayList<Pokemon> buscarPokemonCidade(int id){
        connect();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon WHERE local_idlocal = " + id;
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

    // ----------------------------ATUALIZANDO CIDADE----------------------------
    public boolean atualizarCidade(int id, String nome){
        connect();
        String sql = "UPDATE local SET nome=? WHERE idlocal=?";
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
    public boolean deletarCidade(int id) {
        connect();
        String sql = "DELETE FROM local WHERE idlocal = " + id;
        try{
            pst = connection.prepareStatement(sql);
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
