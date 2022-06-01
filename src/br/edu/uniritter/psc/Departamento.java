package br.edu.uniritter.psc;

public class Departamento {

    private int id;
    private String descricao;

    public Departamento(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}


