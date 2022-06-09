package pokemon;

import lombok.Data;

@Data
public abstract class Pokemon {


    protected int id;
    protected String nome;
    protected String tipo;
    protected int atk;
    protected int def;
    protected int vida;
    protected int lvl;
    protected boolean shiny;
    protected boolean possui;


    public Pokemon(int id, String nome, String tipo, int atk, int def, int vida, int lvl, boolean shiny, boolean possui) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.atk = atk;
        this.def = def;
        this.vida = vida;
        this.lvl = lvl;
        this.shiny = shiny;
        this.possui = possui;
    }

    private void capturar(){

    }


    private void atacar(){
        System.out.println(this.getNome() + "Atacou");
    }


}
