package com.lcl.indexseletor;

public class Atividade {

    public static Atividade novaAtividade(String titulo, TamanhoAtividade e, StatusDaExecucao status) {
        return new Atividade(titulo, e, status);
    }

    private String titulo = "NO TITLE";
    private TamanhoAtividade tamanhoAtividade;
    private StatusDaExecucao statusExecucao;

    public Atividade(String titulo, TamanhoAtividade e, StatusDaExecucao status) {
        this.titulo = titulo;
        this.tamanhoAtividade = e;
        this.statusExecucao = status;
    }

    String titulo() {
        return titulo;
    }

   
     TamanhoAtividade tamanhoAtividade() {
        return tamanhoAtividade;
    }
      Integer notaAtividade() {
        return statusExecucao.valor;
    }
    

}
