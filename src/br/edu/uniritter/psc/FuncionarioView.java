package br.edu.uniritter.psc;

import java.util.List;
import java.util.Scanner;

public class FuncionarioView {
    Scanner scanner = new Scanner(System.in);

    public void listarComSalario(List<Funcionario> lista) {
        for (int i =0; i < lista.size(); i++) {
            Funcionario f = lista.get(i);
            System.out.println(i+"-> ("+f.getId()+") "+f.getNome()+" - "+f.getCargo().getDescricao()+ " - " + f.getDepartamento().getDescricao() + " R$ "+f.getSalario());
        }
    }
    public void listarSemSalario(List<Funcionario> lista) {
        for (int i =0; i < lista.size(); i++) {
            Funcionario f = lista.get(i);
            System.out.println(i+"-> "+f.getNome()+" - "+f.getCargo().getDescricao());
        }
    }
    public void displayFuncionario(Funcionario funcionario) {
        System.out.println("--------------------------------");
        System.out.println("ID: "+funcionario.getId());
        System.out.println("Nome: "+ funcionario.getNome());
        System.out.println("Depto.: "+funcionario.getDepartamento().getDescricao());
        System.out.println("Cargo: "+funcionario.getCargo().getDescricao());
        System.out.println("Matrícula: "+funcionario.getMatricula());
        System.out.println("--------------------------------");
    }

    public Funcionario displayFormularioFuncionario(List<Cargo> cargos, List<Departamento> departamentos){//(Funcionario funcionario) {

        System.out.print("Informe o Nome: ");
        String nome = scanner.next();
        System.out.print("Informe a Matrícula: ");
        int matricula = scanner.nextInt();
        System.out.print("Informe o Salário: ");
        float sal = scanner.nextFloat();
        Cargo cargo = selecionaCargo(cargos);
        Departamento departamento = selecionaDepartamento(departamentos);
        Funcionario f = new Funcionario(0, matricula, nome, cargo, sal, departamento);
        return f;
    }

    public Cargo selecionaCargo(List<Cargo> cargos) {

        for (int i = 0; i < cargos.size(); i++) {
            System.out.println(i+" -> "+cargos.get(i).getDescricao());
        }
        System.out.print("Selecione o cargo: ");
        int c = scanner.nextInt();

        return cargos.get(c);
    }

    public Departamento selecionaDepartamento(List<Departamento> departamentos) {
        for (int i = 0; i < departamentos.size(); i++) {
            System.out.println(i+" -> "+departamentos.get(i).getDescricao());
        }
        System.out.print("Selecione o departamento: ");
        int c = scanner.nextInt();

        return departamentos.get(c);
    }
}
