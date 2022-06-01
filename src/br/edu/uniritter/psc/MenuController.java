package br.edu.uniritter.psc;

public class MenuController {

    MenuView menuView;
    FuncionarioController funcionarioController;

    public MenuController() {
        this.menuView = new MenuView();
        this.funcionarioController = new FuncionarioController();

    }

    public void run() {
        int retorno;
        while (true) {
            retorno = menuView.mostraMenu();
            processaMenu(retorno);

        }
    }
    private void processaMenu(int op) {
        switch (op) {
            case 1:
                funcionarioController.novoFuncionario();
                break;
            case 2:
                funcionarioController.listarComSalario();
                break;
            case 3:
                funcionarioController.listarSemSalario();
                break;
            case 4:
                funcionarioController.alterarFuncionario();
                break;
            case 0:
                System.exit(0);
        }
    }
}
