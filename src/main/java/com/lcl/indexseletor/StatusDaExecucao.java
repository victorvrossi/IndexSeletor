package com.lcl.indexseletor;


enum StatusDaExecucao {
DIA(0),COM_ATRASO(1),EM_ADIANTAMENTO(1);
    int valor;
    private StatusDaExecucao(int valor) {
        this.valor = valor;
    }
        
}
