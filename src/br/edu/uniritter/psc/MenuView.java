package br.edu.uniritter.psc;

import java.util.Scanner;

public class MenuView {

    public int mostraMenu() {
        System.out.println("1. adionar Funcionario");
        System.out.println("2. listar Funcionario/salários");
        System.out.println("3. listar Funcionario");
//        System.out.println("4. alterar Funcionario");
//        System.out.println("5. apagar Funcionario");
        System.out.println("0. sair");
        System.out.println("");
        System.out.print("informe sua opção: ");
        Scanner scanner = new Scanner(System.in);
        int op = -1;
        while (op<0 || op>5) {
            op = scanner.nextInt();
        }
        //System.out.println("você escolheu "+op);
        return op;


    }
}
