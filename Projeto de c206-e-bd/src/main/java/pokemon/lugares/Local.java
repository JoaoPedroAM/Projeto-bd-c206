package pokemon.lugares;

import pokemon.treinador.GeradorPokemon;

import java.util.Random;

public abstract class Local implements GeradorPokemon {
    protected int idlocal;
    protected String nome;

    public void randomizaLevel(){
        Random r = new Random();
        int low = 1;
        int high = 100;
        int result = r.nextInt(high-low) + low;

    }

}
