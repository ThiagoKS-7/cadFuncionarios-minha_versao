package br.edu.uniritter.psc;

public class FuncionarioController {

    FuncionarioDB db;
    FuncionarioView view;

    public FuncionarioController() {
        this.db = FuncionarioDB.getInstance(); //NÃO CRIA UM NOVO, PEGA O JÁ CRIADO NA CLASSE
        this.view = new FuncionarioView();
    }

    public void novoFuncionario() {
        Funcionario f = view.displayFormularioFuncionario(db.getCargos(), db.getDepartamentos());
        db.incluir(f);
        view.displayFuncionario(f);
    }

    public void listarComSalario() {
         view.listarComSalario(db.getTodosFuncionarios());
    }
    public void listarSemSalario() {
        view.listarSemSalario(db.getTodosFuncionarios());
    }
    public void alterarFuncionario() {
        db.getTodosFuncionarios().get(0).setSalario(2000);
    }
}
