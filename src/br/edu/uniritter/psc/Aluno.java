package br.edu.uniritter.psc;

public class Aluno extends Pessoa{
    private String curso;

    public Aluno(int id, int matricula, String nome,String curso) {
        super(id,matricula, nome);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
