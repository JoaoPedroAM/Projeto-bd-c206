package Database;

import pokemon.Pokedex;
import pokemon.Pokemon;
import pokemon.PokemonPossuido;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PokedexDB extends Connection{

    Scanner sc = new Scanner(System.in);

    // ------------------------- CRIAR POKEDEX ----------------------------
    public boolean criarPokedex(int id){
        connect();
        String sql = "INSERT INTO Pokedex(idpokedex) VALUES(?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Esse ID para save ja existe ");
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
    public boolean deletarSave(int id) {
        connect();
        String sql = "DELETE FROM pokedex WHERE idpokedex = " + id;
        try{
            pst = connection.prepareStatement(sql);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Esse save nao existe ");
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
            pokemonDB.buscarPokemonID(id);
            System.out.println("LVL = " + lvl);
            if(shiny == true){
                System.out.println("PARABENSSS É SINHIII KARAI !!!!! 1 em 1000 desgraca");
            }
            else {

            }
            pst.setInt(1,save);      // concatena nome na primeira ? do comando
            pst.setInt(2,id);
            pst.setInt(3,local);   // concatena nome na segunda ? do comando;
            pst.setInt(4,lvl);
            pst.setBoolean(5,shiny);
            pst.execute();
            check = true;
        } catch (SQLException e) {
            int aux = 0;
            System.out.println("Esse pokemon ja foi encontrado, gostaria de substituilo?");
            System.out.println("1 - sim");
            System.out.println("≠ - nao");
            aux = sc.nextInt();
            switch (aux){
                case 1:
                    trocarPokemon(id,save,lvl,shiny);
                    break;
                default:
                    break;
            }
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro de operação: " + e.getMessage());
            }
        }
        return check;
    }

    // --------------------------ATUALIZANDO POKEMON----------------------------
    public boolean trocarPokemon(int id,int save,int lvl, boolean shiny){
        connect();
        String sql = "UPDATE pokemon_da_pokedex SET pokemon_lvl = ?, pokemon_shiny = ? WHERE pokemon_idpokemon=? and pokedex_idpokedex = ?; ";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, lvl);
            pst.setBoolean(2, shiny);
            pst.setInt(3, id);
            pst.setInt(4, save);
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
