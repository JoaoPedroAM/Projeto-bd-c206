package pokemon.treinador;

import lombok.Data;

public class Treinador {

    private int idtreinador;
    private String nome;

    public Treinador(int idtreinador, String nome) {
        this.idtreinador = idtreinador;
        this.nome = nome;
    }

    public Treinador() {
    }

    public int getIdtreinador() {
        return idtreinador;
    }

    public void setIdtreinador(int idtreinador) {
        this.idtreinador = idtreinador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
