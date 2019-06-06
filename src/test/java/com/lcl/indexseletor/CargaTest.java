package com.lcl.indexseletor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class CargaTest {
    @Test
    public void testResgataApenasUmValorMapaDoIndexadsor() {
        Indexador n = Indexador.novo();
        
        // Atendimento
        criaAtividadeEAdicionaAoIndexador(n,"Nova Configuração Tela de Atendimento 1",TamanhoAtividade.P, StatusDaExecucao.DIA);
        criaAtividadeEAdicionaAoIndexador(n,"Alterar Tela de Atendimento 2",TamanhoAtividade.M, StatusDaExecucao.COM_ATRASO);
        criaAtividadeEAdicionaAoIndexador(n,"Alterar Tela de Atendimento 2",TamanhoAtividade.G, StatusDaExecucao.DIA);
        criaAtividadeEAdicionaAoIndexador(n,"Reconfigurar Tela de Atendimento 3",TamanhoAtividade.P, StatusDaExecucao.EM_ADIANTAMENTO);
        criaAtividadeEAdicionaAoIndexador(n,"Mais uma Tela de Atendimento 4",TamanhoAtividade.G, StatusDaExecucao.DIA);
        criaAtividadeEAdicionaAoIndexador(n,"Erro na Tela de Atendimento 5",TamanhoAtividade.G, StatusDaExecucao.DIA);
        
        // Botão
        criaAtividadeEAdicionaAoIndexador(n,"Erro no Botão de negociação 5",TamanhoAtividade.G, StatusDaExecucao.DIA);
        criaAtividadeEAdicionaAoIndexador(n,"Alterar no Botão de negociação 5",TamanhoAtividade.M, StatusDaExecucao.DIA);
        criaAtividadeEAdicionaAoIndexador(n,"Colocar Botão de negociação  na Tela de Atendimento ",TamanhoAtividade.G, StatusDaExecucao.DIA);
        criaAtividadeEAdicionaAoIndexador(n,"Tela trava ao clicar no Botão de negociação 5",TamanhoAtividade.M, StatusDaExecucao.COM_ATRASO);
        criaAtividadeEAdicionaAoIndexador(n,"Alterar Posição do Botão de negociação 5",TamanhoAtividade.P, StatusDaExecucao.EM_ADIANTAMENTO);
        
        
        assertEquals(TamanhoAtividade.G, n.avaliarMelhorStatusParaAtividadesCom("Tela de Atendimento"));
        assertEquals(TamanhoAtividade.G, n.avaliarMelhorStatusParaAtividadesCom("Botão"));
                
    }

    private void criaAtividadeEAdicionaAoIndexador(Indexador n,String nome,TamanhoAtividade s,StatusDaExecucao e) {
        Atividade instance = Atividade.novaAtividade(nome,s,e);
        n.adicionaAtividade(instance);
    }
}
