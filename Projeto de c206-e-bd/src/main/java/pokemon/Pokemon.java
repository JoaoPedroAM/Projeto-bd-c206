package pokemon;

import lombok.Data;

@Data
public class Pokemon {



    protected int id;
    protected String nome;
    protected String tipo;
    protected int lvl;
    protected boolean shiny;
    protected boolean possui;
    protected int local_idlocal;

    public Pokemon(int id, String nome, String tipo, int local_idlocal) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.local_idlocal = local_idlocal;
    }

    public Pokemon(int id, String nome, String tipo, int lvl, boolean shiny, boolean possui, int local_idlocal) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.lvl = lvl;
        this.shiny = shiny;
        this.possui = possui;
        this.local_idlocal = local_idlocal;
    }
}
