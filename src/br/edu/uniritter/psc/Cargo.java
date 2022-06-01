package br.edu.uniritter.psc;

public class Cargo {
    private int id;
    private String descricao;
    private float pisoSalarial;


    public Cargo(int id, String descricao, float pisoSalarial) {
        this.id = id;
        this.descricao = descricao;
        this.pisoSalarial = pisoSalarial;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPisoSalarial() {
        return pisoSalarial;
    }
}
