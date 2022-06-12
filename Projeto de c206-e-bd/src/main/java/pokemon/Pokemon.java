package pokemon;

import lombok.Data;
import pokemon.treinador.GeradorPokemon;

@Data
public class Pokemon implements GeradorPokemon {



    protected int id;
    protected String nome;
    protected String tipo;
    protected int lvl;
    protected boolean shiny;
    protected boolean possui;


    public Pokemon(int id, String nome, String tipo, int lvl, boolean shiny, boolean possui) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.lvl = lvl;
        this.shiny = shiny;
        this.possui = possui;
    }







}
