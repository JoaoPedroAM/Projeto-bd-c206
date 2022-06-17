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



}
