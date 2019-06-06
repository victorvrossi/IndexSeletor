package com.lcl.indexseletor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IndexadorTest {

    @Test
    public void testAdicionaAtividadeAoIndexador() {
        Atividade instance = Atividade.novaAtividade("Tela de Atendimento",TamanhoAtividade.P,StatusDaExecucao.DIA);
        Indexador n = Indexador.novo();
        assertEquals(true, n.adicionaAtividade(instance));
    }
    @Test
    public void testValidaMapaDoIndexador() {
        Atividade instance = Atividade.novaAtividade("Tela de Atendimento",TamanhoAtividade.P,StatusDaExecucao.DIA);
        Indexador n = Indexador.novo();
        n.adicionaAtividade(instance);
        assertEquals(true, n.acessarMapa().verificarSeTem("Tela"));
                
    }
    @Test
    public void testValidaValorMapaDoIndexador() {
        Atividade instance = Atividade.novaAtividade("Tela de Atendimento",TamanhoAtividade.P,StatusDaExecucao.DIA);
        Indexador n = Indexador.novo();
        n.adicionaAtividade(instance);
        assertEquals(1, n.acessarMapa().resgataValor("Tela").size());
                
    }
    
    @Test
    public void testValidarAvaliacaoParaAtividade() {
        Indexador n = Indexador.novo();
        
        criaAtividadeEAdicionaAoIndexador(n,"Tela de Atendimento 1");
        criaAtividadeEAdicionaAoIndexador(n,"Tela de Atendimento 2");
        criaAtividadeEAdicionaAoIndexador(n,"Tela de Cadastro 5");
        criaAtividadeEAdicionaAoIndexador(n,"Botão de Cadastro 2");
        assertEquals(TamanhoAtividade.P, n.avaliarMelhorStatusParaAtividadesCom("Tela de Atendimento"));
                
    }
    
    @Test
    public void testResgataApenasUmValorMapaDoIndexadsor() {
        Indexador n = Indexador.novo();
        
        criaAtividadeEAdicionaAoIndexador(n,"Nova Configuração Tela de Atendimento 1",TamanhoAtividade.P, StatusDaExecucao.DIA);
        criaAtividadeEAdicionaAoIndexador(n,"Alterar Tela de Atendimento 2",TamanhoAtividade.M, StatusDaExecucao.COM_ATRASO);
        criaAtividadeEAdicionaAoIndexador(n,"Alterar Tela de Atendimento 2",TamanhoAtividade.G, StatusDaExecucao.DIA);
        criaAtividadeEAdicionaAoIndexador(n,"Reconfigurar Tela de Atendimento 3",TamanhoAtividade.P, StatusDaExecucao.EM_ADIANTAMENTO);
        criaAtividadeEAdicionaAoIndexador(n,"Mais uma Tela de Atendimento 4",TamanhoAtividade.G, StatusDaExecucao.DIA);
        criaAtividadeEAdicionaAoIndexador(n,"Erro na Tela de Atendimento 5",TamanhoAtividade.G, StatusDaExecucao.DIA);
        assertEquals(TamanhoAtividade.G, n.avaliarMelhorStatusParaAtividadesCom("Tela de Atendimento"));
                
    }

    private void criaAtividadeEAdicionaAoIndexador(Indexador n,String nome) {
        Atividade instance = Atividade.novaAtividade(nome,TamanhoAtividade.P,StatusDaExecucao.DIA);
        n.adicionaAtividade(instance);
    }
    private void criaAtividadeEAdicionaAoIndexador(Indexador n,String nome,TamanhoAtividade s,StatusDaExecucao e) {
        Atividade instance = Atividade.novaAtividade(nome,s,e);
        n.adicionaAtividade(instance);
    }
    
    
}
