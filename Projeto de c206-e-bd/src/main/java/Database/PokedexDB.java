package Database;

import pokemon.Pokedex;
import pokemon.Pokemon;

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

}
