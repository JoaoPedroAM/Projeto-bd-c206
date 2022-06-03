package pokemon;

import lombok.Data;

@Data
public abstract class Pokemon {
    protected String nome;
    protected String tipo;
    protected double atk;
    protected double def;
    protected int vida;
    protected int lvl;
    protected boolean shiny;





    private void capturar(){

    }


    private void atacar(){
        System.out.println(this.getNome() + "Atacou");
    }


}
