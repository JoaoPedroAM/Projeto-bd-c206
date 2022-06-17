package Pokemon;

public class PokemonPossuido extends Pokemon {

    private int lvl;
    private boolean shiny;
    private int minhaPokedex;

    public PokemonPossuido(int id, String nome, String tipo, int local_idlocal, int minhaPokedex, int atoa1, int atoa2, int lvl, boolean shiny) {
        super(id, nome, tipo, local_idlocal);
        this.lvl = lvl;
        this.shiny = shiny;
        this.minhaPokedex = minhaPokedex;
    }

    public PokemonPossuido(int id, String nome, String tipo, int lvl, boolean shiny) {
        super(id, nome, tipo);
        this.lvl = lvl;
        this.shiny = shiny;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public boolean isShiny() {
        return shiny;
    }

    public void setShiny(boolean shiny) {
        this.shiny = shiny;
    }

    public int getMinhaPokedex() {
        return minhaPokedex;
    }

    public void setMinhaPokedex(int minhaPokedex) {
        this.minhaPokedex = minhaPokedex;
    }
}

