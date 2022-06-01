package br.edu.uniritter.psc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioFile {
    // CONSTANTES DE NOME E DIRETÓRIO DO ARQUIVO
    private static final String NOME_ARQ = "funcionarios.csv";
    private static final String DIR_ARQ = "C:/Users/W10/Downloads";

    public FuncionarioFile() {
        File dir = new File(DIR_ARQ);
        /* SE O DIRETÓRIO NÃO EXISTIR, CRIA ELE */
        if (!dir.exists()) {
            dir.mkdir();
        }

    }
    /*TRANSFORMA O RETORNO DE FUNCIONARIO NUMA LINHA COM OS DADOS SEPARADOS POR ;*/
    private String converteFuncionarioPraCSV(Funcionario funcionario) {
        return funcionario.getClass().getName() + ";" + funcionario.getId() + ";" + funcionario.getMatricula() + ";" + funcionario.getNome() + ";" + funcionario.getSalario() + ";" + funcionario.getCargo().getId() + ";" + (funcionario.getDepartamento() != null ? funcionario.getDepartamento().getId() : 0) + ";\n";
    }
    /*
    * PEGA TUDO QUE VEM NA CSV E TRANSFORMA OS REGISTROS NUMA LISTA,
    * QUE PASSA ESSES DADOS COMO ATRIBUTOS PRA CRIAÇÃO DE UM FUNCIONÁRIO
    * */
    private Funcionario converteCSVPraFuncionario(String linha) {
        String[] campos = linha.split(";");
        FuncionarioDB db = FuncionarioDB.getInstance(); // PEGA A INSTANCIA CRIADA NA CLASSE
        /* CRIA O FUNCIONARIO COM BASE NA LINHA LIDA PELO ARQUIVO */
        Funcionario f = new Funcionario(
                Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                campos[3],
                db.getCargos().get(Integer.parseInt(campos[5]) - 1),
                Float.parseFloat(campos[4]),
                db.getDepartamentos().get(Integer.parseInt(campos[6]) -1)
        );
        return f;
    }

    public void salvaFuncionarios(List<Funcionario> lista) {
        System.out.println(lista);
        File arquivo = new File(DIR_ARQ + "/" + NOME_ARQ);
        /* TENTA GRAVAR NOVO ARQUIVO, SE DER RUIM LANÇA UM ERRO DE IO*/
        try {
            System.out.println(lista);
            //boolean newFile = arquivo.createNewFile();
            FileOutputStream fos = new FileOutputStream(arquivo);

            for(int i = 0; i < lista.size(); ++i) {
                //CONVERTE PRA CSV E TRANSFORMA O CONTEÚDO PRA BYTES
                fos.write(this.converteFuncionarioPraCSV(lista.get(i)).getBytes());
            }
            /* DESCARREGA NO ARQUIVO E FECHA O ARQUIVO */
            fos.flush();
            fos.close();
        } catch (IOException var6) {
            //LOGA O ERRO DE ACESSO A DISCO
            var6.printStackTrace();
        }

    }
    /* TENTA PEGAR UM ARQUIVO EXISTENTE */
    public ArrayList carregarFuncionarios(FuncionarioDB db) {
        /*TENTA ACHAR O ARQUIVO NO PATHNAME ENVIADO*/
        File arquivo = new File(DIR_ARQ+"/"+NOME_ARQ);
        ArrayList retorno = new ArrayList<>();
        try {
            /*TENTA LER O ARQUIVO ENCONTRADO*/
            Scanner fileScanner = new Scanner(arquivo);
            /*
            *ENQUANTO O ARQUIVO TIVER MAIS UMA LINHA DE CONTEÚDO,
            *ELE FAZ A CONVERSÃO DISSO PRA LISTA FUNCIONARIO
            */
            while(fileScanner.hasNextLine()) {
                String linha = fileScanner.nextLine();
                /*CHAMA A CONVERSÃO, ADICIONANDO O FUNCIONARIO CRIADO DIRETO NO ARQUIVO*/
                Funcionario f = converteCSVPraFuncionario(linha);
                retorno.add(f);
                db.setIdAtual(f.getId());
            }

            fileScanner.close(); //FECHA O SCANNER
            } catch (FileNotFoundException var8) {
                // PRINTA O ERRO DE ARQUIVO NÃO ENCONTRADO
                var8.printStackTrace();
            }

            return retorno;
    }
}
