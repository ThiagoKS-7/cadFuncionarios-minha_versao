package br.edu.uniritter.psc;

public class Funcionario extends Pessoa{
    private float salario;
    private Cargo cargo;
    private Departamento departamento;


    public Funcionario(int id, int matricula, String nome, Cargo cargo, float salario, Departamento departamento) {
        /*CHAMA O CONSTRUTOR DA CLASSE MÃE (PESSOA)*/
        super(id,matricula,nome);
        this.cargo = cargo;
        this.departamento = departamento;
        this.setSalario(salario);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Funcionario) {
            return this.getId() == ((Funcionario) obj).getId();
        } else {
            return false;
        }
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario < this.cargo.getPisoSalarial()) {
            this.salario = cargo.getPisoSalarial();
        } else {
            this.salario = salario;
        }
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
