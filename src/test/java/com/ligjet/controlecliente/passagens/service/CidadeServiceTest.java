package com.ligjet.controlecliente.passagens.service;

import com.ligjet.controlecliente.passagens.entity.Cidade;
import com.ligjet.controlecliente.passagens.repository.CidadeRepository;
import com.ligjet.controlecliente.passagens.service.impl.CidadeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CidadeServiceTest {

    @InjectMocks // Ajuda a criar uma instância falsa da classe que está sendo testada (service)
    CidadeServiceImpl service;

    @Mock // Cria uma instância falsa (mock) do CidadeRepository
    CidadeRepository repository;

    Cidade cidade;

    @BeforeEach// Indica que um método deve ser executado antes de cada teste individual
    public void setUp(){
        cidade = new Cidade("CIDADE1", "Salvador", "BA", "40330-201");
    }

    @Test
    void deveRetornarTodasAsCidades() {
        List<Cidade> cidades = Arrays.asList(new Cidade("CIDADE1", "Salvador", "BA", "40330-201"), new Cidade("CIDADE2", "Rio de Janeiro", "RJ", "12345-678"));//mocar os dados de um usuário
        when(repository.findAll()).thenReturn(cidades);//Quando o repository chamar o método findAll, retornar a lista cidades

        List<Cidade> result = service.findAllCidades();//Confirma que o método service.findAll está retornando corretamente

        assertEquals(2, result.size());// verifica se o valor esperado é igual ao valor obtido no teste (2 cidades na lista)
        verify(repository).findAll();//verifica se o método findAll foi invocado
        verifyNoMoreInteractions(repository);//Se houver mais chamadas ao mock (além desse de cima), o teste vai dar erro
    }

    @Test // Identifica o teste para ser realizado
    void deveBuscarCidadesPorIdComSucesso(){
        when(repository.findById(cidade.getIdCidade())).thenReturn(Optional.of(cidade)); // Quando simular a procura do ID, tem que retornar um tipo opcional
        Cidade result = service.findById(cidade.getIdCidade());// Confirma que o método service.findById está retornando a Cidade correta

        assertEquals(cidade, result);// Compara o objeto result retornado pelo método service.findById é o mesmo que o objeto cidade esperado.
        verify(repository).findById(cidade.getIdCidade());// Verifica se o método findById do repository foi de fato invocado durante o teste.
        verifyNoMoreInteractions(repository);// Se houver chamadas adicionais ao mock, o teste falhará, indicando que o código possui execuções extras ou imprevistas.
    }

    @Test
    void naoDeveChamarORepositoryCasoIdNull(){
        final RuntimeException e = assertThrows(RuntimeException.class, () -> { //usada para testar se uma exceção é lançada quando o método save é executado
            service.save(null, "", "", "");//Simula a execução do save com o id null
        });

        // Verifica se a exceção não é nula
        assertThat(e, notNullValue());

        // Verifica se a mensagem da exceção está correta
        assertThat(e.getMessage(), is("Cidade não encontrada com ID: null"));

        // Verifica que o repositório não foi chamado
        verifyNoInteractions(repository);

    }
    @Test
    void deveChamarExceptionQuandoORepositoryFalhar() {
        // Simula o comportamento do repositório para lançar uma exceção quando findById for chamado
        when(repository.findById(cidade.getIdCidade()))
                .thenThrow(new RuntimeException("Cidade não encontrada com ID: " + cidade.getIdCidade()));

        // Testa se o método service.findById lança uma exceção corretamente
        final RuntimeException e = assertThrows(RuntimeException.class, () -> {
            service.findById(cidade.getIdCidade());
        });

        // Verifica se a mensagem da exceção é a esperada
        assertThat(e.getMessage(), is(format("Cidade não encontrada com ID: %s", cidade.getIdCidade())));

        // Verifica se a causa da exceção é uma RuntimeException
        assertThat(e.getCause(), is(nullValue()));  // Aqui a causa deve ser null porque não estamos envolvê-la com outra exceção

        // Verifica se o método findById foi chamado no repositório
        verify(repository).findById(cidade.getIdCidade());

        // Verifica se não há mais interações com o repositório após essa chamada
        verifyNoMoreInteractions(repository);
    }

    @Test
    void deveExcluirCidadeComSucesso() {
        // Esse doNothing() verifica se o método foi chamado, mas não se importa com o efeito colateral real (como uma exclusão ou atualização no banco de dados).
        doNothing().when(repository).deleteById(cidade.getIdCidade());

        // Chama o método 'delete' da service
        service.delete(cidade.getIdCidade());

        // Verifica se o método deleteById foi chamado corretamente
        verify(repository).deleteById(cidade.getIdCidade());

        // Verifica que não houve mais interações com o repositório após essa chamada
        verifyNoMoreInteractions(repository);
    }

}