package pokemon.lugares;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Local {
    protected int idlocal;
    protected String nome;

    public Local(int idlocal, String nome) {
        this.idlocal = idlocal;
        this.nome = nome;
    }

    public Local() {
    }

    public static int gerarLvl(){
        int max = 100;
        int min = 1;
        Random random = new Random();
        int level = random.nextInt(max - min + 1) + min;


        return level;
    }

    public static boolean gerarShiny(){
        int max = 100;
        int min = 1;
        Random random = new Random();
        int sorte = random.nextInt(max - min + 1) + min;
        if(sorte == 100){
            return true;
        }
        else
            return false;

    }

    public static int gerarpokemon(int max, int min){
        Random random = new Random();
        int level = random.nextInt(max - min + 1) + min;
        return level;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
