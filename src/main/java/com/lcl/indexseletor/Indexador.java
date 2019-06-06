package com.lcl.indexseletor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Indexador {

    static Indexador novo() {
        return new Indexador();
    }
    private MapaDeEntrada mapa = new MapaDeEntrada();

    boolean adicionaAtividade(Atividade instance) {
        mapa.adicionaAoMapa(instance);
        return true;
    }

    MapaDeEntrada acessarMapa() {
        return this.mapa;
    }

    TamanhoAtividade avaliarMelhorStatusParaAtividadesCom(String tela_de_Atendimento) {
        String[] split = tela_de_Atendimento.split(" ");
        ArrayList<Atividade> end = new ArrayList<>();
        for (String s : split) {
            ArrayList<Atividade> novo = mapa.resgataValor(s);
            if (end.isEmpty()) {
                end.addAll(novo);
                continue;
            }
            end = filtra(novo, end);
        }

        Map<TamanhoAtividade, Integer> nota = new HashMap<>();
        mapeiaNotas(end, nota);

        int menorNota = 0;
        TamanhoAtividade melhorTamanho = null;
        for (Map.Entry<TamanhoAtividade, Integer> n : nota.entrySet()) {
            TamanhoAtividade key = n.getKey();
            java.lang.Integer value = n.getValue();
            if (melhorTamanho == null) {
                menorNota = value;
                melhorTamanho = key;
            }

            if (menorNota > value) {
                menorNota = value;
                melhorTamanho = key;
            }

        }

        return melhorTamanho;
    }

    private void mapeiaNotas(ArrayList<Atividade> end, Map<TamanhoAtividade, Integer> nota) {
        for (Atividade at : end) {
            if (nota.containsKey(at.tamanhoAtividade())) {
                nota.replace(at.tamanhoAtividade(), nota.get(at.tamanhoAtividade()) + at.notaAtividade());
            } else {
                nota.put(at.tamanhoAtividade(), at.notaAtividade());
            }

        }
    }

    private ArrayList<Atividade> filtra(ArrayList<Atividade> novo, ArrayList<Atividade> atual) {
        ArrayList<Atividade> end = new ArrayList<>();
        for (Atividade att : novo) {
            if (atual.contains(att)) {
                end.add(att);
            }
        }
        return end;
    }

}
