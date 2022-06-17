package Pokemon;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLocal_idlocal() {
        return local_idlocal;
    }

    public void setLocal_idlocal(int local_idlocal) {
        this.local_idlocal = local_idlocal;
    }
}
