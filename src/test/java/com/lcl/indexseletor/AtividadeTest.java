
package com.lcl.indexseletor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtividadeTest {
    

    @Test
    public void testVerificaTitulo() {
        Atividade instance = Atividade.novaAtividade("Tela de Atendimento",TamanhoAtividade.P,StatusDaExecucao.DIA);
        assertEquals("Tela de Atendimento", instance.titulo());
    }
    
  
    
}
