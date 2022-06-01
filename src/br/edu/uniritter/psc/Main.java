package br.edu.uniritter.psc;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /* Classe inical - roda o menu do programa */
        MenuController menuController = new MenuController();
        menuController.run();
//        List<Cargo>  cargos = new ArrayList<>();
//        Cargo c = new Cargo(0, "Prof. Nv.1", 1200f);
//        Cargo c2 = new Cargo(1, "Prof. Nv.2", 4200f);
//        cargos.add(c);
//        cargos.add(c2);
//        Map<Integer,Cargo> mapaCargos = new HashMap<>();
//        /*VALIDAÇÃO QUE IMPEDE ID REPETIDO*/
//            mapaCargos.put(c.getId(),c);
//            mapaCargos.put(777,c);
//            mapaCargos.put(c2.getId(),c2);
//            mapaCargos.put(777,c2);
//            System.out.println(mapaCargos);
//        for (int i = 0; i < cargos.size(); i ++) {
//            System.out.println(cargos.get(i).getId() +" -> "+cargos.get(i).getDescricao());
//        }

    }
}
