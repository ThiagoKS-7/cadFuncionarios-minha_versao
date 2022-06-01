package br.edu.uniritter.psc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioDB {
    private List<Funcionario> funcionarios;
    private  List<Cargo> cargos;
    FuncionarioFile funcFile;
    private List<Departamento> departamentos;
    private int idAtual = 0;
    private static FuncionarioDB instancia; // USANDO DESIGN PATTERN SINGLETON

    /* CRIA NOVA INSTANCIA SE ELA FOR NULA */
    public static FuncionarioDB getInstance() {
        if(instancia == null) {
            /* CRIA O ARQUIVO DO BANCO DE DADOS A PARTIR DA INSTANCIA JÁ EXISTENTE*/
            instancia = new FuncionarioDB();
            instancia.funcFile = new FuncionarioFile();
            ArrayList ret = instancia.funcFile.carregarFuncionarios(instancia);
            instancia.funcionarios.addAll(ret);
        }
        // SE JÁ EXISTIR SÓ RETORNA
        return instancia;
    }

    private FuncionarioDB() {
        funcionarios = new ArrayList<>();
        cargos = new ArrayList<>();
        departamentos = new ArrayList<>();

        /*CRIANDO OPÇÕES DE CARGO E DEPARTAMENTO*/
        //#TODO: FAZER ARQUIVOS DE CARGO E DEPARTAMENTO
        cargos.add(new Cargo(1, "Prof. Nv.1", 1200f));
        cargos.add(new Cargo(2, "Prof. Nv.2", 4200f));
        cargos.add(new Cargo(3, "Coordenador", 9200f));
        cargos.add(new Cargo(4, "Diretor", 12000f));
        departamentos.add(new Departamento(1, "Acadêmico"));
        departamentos.add(new Departamento(2, "Secretaria"));
        departamentos.add(new Departamento(3, "Financeiro"));

    }
    /*CORRIGE O ID NO FUNCIONARIO FILE*/
    public void setIdAtual(int id) {
        this.idAtual = id;
    }
    public void incluir(Funcionario funcionario) {
        /* CONFIGURA ID UNICO */
        if (funcionario.getId() == 0) {
            this.idAtual++;
            funcionario.setId(this.idAtual);
        }
        /* CHECA SE O FUNCIONARIO JÁ EXISTE */
        if (this.funcionarios.contains(funcionario)) {
            System.out.println("funcionario já existe");
        } else {
            /* ADICIONA FUNCIONARIO */
            this.funcionarios.add(funcionario);
            salvarFuncionariosNoBD();

        }
    }
    public List<Funcionario> getTodosFuncionarios() {
        return this.funcionarios;
    }

    public List<Cargo> getCargos() {
        return this.cargos;
    }

    public List<Departamento> getDepartamentos() {
        return this.departamentos;
    }

    public void salvarFuncionariosNoBD () {
        instancia.funcFile.salvaFuncionarios(this.funcionarios);
    }

    //#TODO: FAZER GET CARGO
    //#TODO: FAZER O FUNCIONARIODB INTEIRO USAR MAP
    //#TODO: GRAVAR CARGO E DEPARTAMENTO

}
