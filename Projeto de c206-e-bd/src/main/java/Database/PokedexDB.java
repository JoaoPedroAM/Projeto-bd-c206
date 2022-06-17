package Database;

import pokemon.Pokedex;
import pokemon.Pokemon;
import pokemon.PokemonPossuido;

import java.sql.SQLException;
import java.util.ArrayList;

public class PokedexDB extends Connection{

    // ------------------------- CRIAR POKEDEX ----------------------------
    public boolean criarPokedex(Pokedex pokedex){
        connect();
        String sql = "INSERT INTO Pokemon(idpokedex) VALUES(?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,pokedex.getIdPokedex());
            pst.execute();
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

    // ------------------------- EXCLUINDO POKEDEX ----------------------------
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

    // --------------------------BUSCANDO TODAS POKEDEXS----------------------------
    public ArrayList<Pokedex> buscarPokedex(){
        connect();
        ArrayList<Pokedex> pokedexs = new ArrayList<>();
        String sql = "SELECT * FROM Pokedex";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Pokedex pokedexTemp = new Pokedex(result.getInt("idpokedex")) {
                };
                pokedexTemp.setIdPokedex(result.getInt("idpokedex"));
                System.out.println("SAVE: " + pokedexTemp.getIdPokedex());
                System.out.println("------------------------------");
                pokedexs.add(pokedexTemp);
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
        return pokedexs;
    }

    // ------------------------- BUSCANDO POKEMONS QUE POSSUI ----------------------------
    public ArrayList<PokemonPossuido> buscarSeusPokemons(int save){
        connect();
        ArrayList<PokemonPossuido> pokemons = new ArrayList<>();
        String sql = "select p.idpokemon, p.nome, p.tipo, px.pokemon_lvl,px.pokemon_shiny from pokemon as p inner join pokemon_da_pokedex as px on p.idpokemon = px.pokemon_idpokemon where pokedex_idpokedex = " + save + ";";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                PokemonPossuido pokemonTemp = new PokemonPossuido(result.getInt("idpokemon"), result.getString("nome"), result.getString("tipo"),result.getInt("pokemon_lvl"),result.getBoolean("pokemon_shiny")) {
                };
                pokemonTemp.setId(result.getInt("idpokemon"));
                System.out.println("ID = " + pokemonTemp.getId());
                System.out.println("NOME = " + pokemonTemp.getNome());
                System.out.println("TIPO = " + pokemonTemp.getTipo());
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

    // ------------------------- INSERIR POKEMON ----------------------------
    public boolean adcionarPokemon(int id,int lvl, boolean shiny, int save, int local ){

        PokemonDB pokemonDB = new PokemonDB();

        connect();
        String sql = "INSERT INTO pokemon_da_pokedex(pokedex_idpokedex, pokemon_idpokemon,pokemon_local_idlocal, pokemon_lvl, pokemon_shiny) VALUES(?, ?, ?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,save);      // concatena nome na primeira ? do comando
            pst.setInt(2,id);
            pst.setInt(3,local);   // concatena nome na segunda ? do comando;
            pst.setInt(4,lvl);
            pst.setBoolean(5,shiny);
            pokemonDB.buscarPokemonID(id);
            pst.execute();
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
                System.out.println("Esse pokemon ja foi encontrado, so lamento");
            }
        }
        return check;
    }
}
