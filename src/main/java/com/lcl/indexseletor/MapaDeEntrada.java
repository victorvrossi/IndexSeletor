package com.lcl.indexseletor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MapaDeEntrada {

    Map<String, ArrayList<Atividade>> m = new HashMap<>();

    boolean verificarSeTem(String tela) {
        return m.containsKey(tela);
    }

    ArrayList<Atividade> resgataValor(String tela) {
        return m.get(tela);
    }

    void adicionaAoMapa(Atividade instance) {
        String[] split = instance.titulo().split(" ");
        for (String string : split) {
            if (m.containsKey(string)) {
                ArrayList<Atividade> get = m.get(string);
                get.add(instance);
                m.replace(string, get);
            } else {
                ArrayList<Atividade> j = new ArrayList<>();
                j.add(instance);
                m.put(string, j);
            }
        }
    }

}
