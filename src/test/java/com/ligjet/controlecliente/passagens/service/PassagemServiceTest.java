package com.ligjet.controlecliente.passagens.service;

import com.ligjet.controlecliente.passagens.entity.Cidade;
import com.ligjet.controlecliente.passagens.entity.Passagem;
import com.ligjet.controlecliente.passagens.entity.Veiculo;
import com.ligjet.controlecliente.passagens.repository.CidadeRepository;
import com.ligjet.controlecliente.passagens.repository.PassagemRepository;
import com.ligjet.controlecliente.passagens.service.impl.CidadeServiceImpl;
import com.ligjet.controlecliente.passagens.service.impl.PassagemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PassagemServiceTest {

    @InjectMocks // Ajuda a criar uma instância da classe que está sendo testada (service)
    PassagemServiceImpl service;

    @Mock // Cria uma instância falsa (mock) do CidadeRepository
    PassagemRepository repository;

    Passagem passagem;

    @BeforeEach
    public void setUp() {
        // Criação do veículo mockado
        Veiculo veiculo = new Veiculo();
        veiculo.setNumero(1L); // Número do veículo

        // Criação das cidades mockadas
        Cidade cidadeOrigem = new Cidade();
        cidadeOrigem.setIdCidade("CIDADE1"); // ID da cidade de origem

        Cidade cidadeDestino = new Cidade();
        cidadeDestino.setIdCidade("CIDADE2"); // ID da cidade de destino

        // Criando a passagem com dados fornecidos
        passagem = new Passagem(1L, 25, java.sql.Date.valueOf("2000-07-25"), "22:22", BigDecimal.valueOf(200.50));
        passagem.setVeiculo(veiculo); // Associando o veículo
        passagem.setCidadeOrigem(cidadeOrigem); // Associando a cidade de origem
        passagem.setCidadeDestino(cidadeDestino); // Associando a cidade de destino

        // Configurando o comportamento do mock do repository
        lenient().when(repository.findById(1L)).thenReturn(Optional.of(passagem));
    }

    @Test
    void deveRetornarTodasAsPassagens() {
        // Moca os dados de Passagens
        List<Passagem> passagens = Arrays.asList(
                new Passagem(1L, 25, java.sql.Date.valueOf("2024-11-15"), "16:00", BigDecimal.valueOf(200.50)),
                new Passagem(2L, 10, java.sql.Date.valueOf("2024-11-16"), "18:30", BigDecimal.valueOf(150.00))
        );

        // Quando o repository chamar o método findAll, retornar a lista de passagens
        when(repository.findAll()).thenReturn(passagens);

        // Chama o método de serviço
        List<Passagem> result = service.findAllPassagens();

        // Verifica se o valor esperado é igual ao valor obtido no teste (2 passagens na lista)
        assertEquals(2, result.size());

        // Verifica se o método findAll foi invocado
        verify(repository).findAll();

        // Verifica que não houve mais interações com o mock
        verifyNoMoreInteractions(repository);
    }

    @Test
    void deveBuscarPassagemPorIdComSucesso() {
        // Moca o comportamento para encontrar uma passagem por ID
        when(repository.findById(1L)).thenReturn(Optional.of(passagem));

        // Chama o método de serviço
        Passagem result = service.findById(1L);

        // Verifica se o objeto retornado é o mesmo que o esperado
        assertEquals(passagem, result);

        // Verifica se o método findById foi chamado com o ID correto
        verify(repository).findById(1L);

        // Verifica que não houve mais interações com o mock
        verifyNoMoreInteractions(repository);
    }

    @Test
    void naoDeveChamarORepositoryCasoIdNull() {
        // Testa se uma exceção é lançada quando o ID é null
        final RuntimeException e = assertThrows(RuntimeException.class, () -> {
            service.save(null, null, 25, java.sql.Date.valueOf("2024-11-15"), "16:00", null, null, BigDecimal.valueOf(200.50));
        });

        // Verifica se a exceção não é nula
        assertThat(e, notNullValue());

        // Verifica a mensagem da exceção
        assertThat(e.getMessage(), is("Passagem não encontrada com ID: null"));

        // Verifica que o repositório não foi chamado
        verifyNoInteractions(repository);
    }

    @Test
    void deveChamarExceptionQuandoORepositoryFalhar() {
        // Simula uma falha no repositório ao buscar a passagem
        when(repository.findById(1L))
                .thenThrow(new RuntimeException("Passagem não encontrada com ID: 1"));

        // Testa se o método lança uma exceção corretamente
        final RuntimeException e = assertThrows(RuntimeException.class, () -> {
            service.findById(1L);
        });

        // Verifica se a mensagem da exceção é a esperada
        assertThat(e.getMessage(), is("Passagem não encontrada com ID: 1"));

        // Verifica se o método findById foi chamado no repositório
        verify(repository).findById(1L);

        // Verifica que não houve mais interações com o repositório
        verifyNoMoreInteractions(repository);
    }

    @Test
    void deveExcluirPassagemComSucesso() {
        // Configura o comportamento para que o repositório não faça nada ao deletar a passagem
        doNothing().when(repository).deleteById(1L);

        // Chama o método delete
        service.delete(1L);

        // Verifica se o método deleteById foi chamado corretamente
        verify(repository).deleteById(1L);

        // Verifica que não houve mais interações com o repositório
        verifyNoMoreInteractions(repository);
    }
}
