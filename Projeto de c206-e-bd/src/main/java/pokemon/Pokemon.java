package pokemon;

import lombok.Data;

@Data
public class Pokemon {



    protected int id;
    protected String nome;
    protected String tipo;
    protected int local_idlocal;

    public Pokemon(int id, String nome, String tipo, int local_idlocal) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.local_idlocal = local_idlocal;

    }


    public Pokemon(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }
}
