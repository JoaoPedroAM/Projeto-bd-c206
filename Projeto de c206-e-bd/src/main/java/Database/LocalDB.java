package Database;
import pokemon.Pokemon;
import pokemon.lugares.Local;

import java.sql.*;
import java.util.ArrayList;

public class LocalDB extends Connection {

    // -------------------- BUSCA DE POKEMONS EM LOCAIS ESPECIFICOS-----------
    public ArrayList<Pokemon> researchPokemonLocal(int idLocal){
        connect();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM Pokemon WHERE local_idlocal = " + idLocal;
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Pokemon pokemonTemp = new Pokemon(result.getInt("idpokemon"), result.getString("nome"), result.getString("tipo"),result.getInt("lvl"),result.getBoolean("shiny"),result.getBoolean("idLocal"),result.getInt("local_idlocal")) {
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

    // ----------------------------- CRIAR CIDADE ----------------------------
    public boolean insertCidade(Local local){
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

    // ----------------------------EXCLUINDO REGISTRO----------------------------
    public boolean deleteCidade(int id) {
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

    // ----------------------------ATUALIZANDO CIDADE----------------------------
    public boolean updatePokemon(int id, String nome){
        connect();
        String sql = "UPDATE local SET nome=? WHERE id=?";
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
}
