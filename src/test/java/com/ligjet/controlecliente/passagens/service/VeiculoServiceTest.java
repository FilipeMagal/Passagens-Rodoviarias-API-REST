package com.ligjet.controlecliente.passagens.service;

import com.ligjet.controlecliente.passagens.entity.Cidade;
import com.ligjet.controlecliente.passagens.entity.Veiculo;
import com.ligjet.controlecliente.passagens.repository.CidadeRepository;
import com.ligjet.controlecliente.passagens.repository.VeiculoRepository;
import com.ligjet.controlecliente.passagens.service.impl.CidadeServiceImpl;
import com.ligjet.controlecliente.passagens.service.impl.VeiculoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class VeiculoServiceTest {

    @InjectMocks // Ajuda a criar uma instância da classe que está sendo testada (service)
    VeiculoServiceImpl service;

    @Mock // Cria uma instância falsa (mock) do VeiculoRepository
    VeiculoRepository repository;

    Veiculo veiculo;

//    @BeforeEach// Indica que um método deve ser executado antes de cada teste individual
//    public void setUp() throws Exception {
//        // Ajustando a data para o tipo Date
//
//        veiculo = new Veiculo(1L, "NTX125", "Bruno", "Ônibus Modelo A", java.sql.Date.valueOf("2000-07-25"), 45);
//    }

    @Test
    void deveRetornarTodosOsVeiculos() {
        // Ajustando os dados dos veículos com datas do tipo Date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date data1 = sdf.parse("2004/11/15");
            Date data2 = sdf.parse("2005/01/01");

            List<Veiculo> veiculos = Arrays.asList(
                    new Veiculo(1L, "NTX125", "Bruno", "Ônibus Modelo A", (java.sql.Date) data1, 45),
                    new Veiculo(2L, "TEX500", "Carlos", "Carro Modelo B", (java.sql.Date) data2, 50)
            );

            when(repository.findAll()).thenReturn(veiculos);

            List<Veiculo> result = service.findAllVeiculos();

            assertEquals(2, result.size());
            verify(repository).findAll();
            verifyNoMoreInteractions(repository);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void deveBuscarVeiculoPorIdComSucesso() {
        veiculo = new Veiculo(1L, "NTX125", "Bruno", "Ônibus Modelo A", java.sql.Date.valueOf("2000-07-25"), 45);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date data = sdf.parse("2000/07/25");


            when(repository.findById(veiculo.getNumero())).thenReturn(Optional.of(veiculo));

            Veiculo result = service.findById(veiculo.getNumero());

            assertEquals(veiculo, result);
            verify(repository).findById(veiculo.getNumero());
            verifyNoMoreInteractions(repository);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void deveChamarExceptionQuandoORepositoryFalhar() {
        veiculo = new Veiculo(1L, "NTX125", "Bruno", "Ônibus Modelo A", java.sql.Date.valueOf("2000-07-25"), 45);

        try {
            when(repository.findById(veiculo.getNumero()))
                    .thenThrow(new RuntimeException("Veículo não encontrado com ID: " + veiculo.getNumero()));

            final RuntimeException e = assertThrows(RuntimeException.class, () -> {
                service.findById(veiculo.getNumero());
            });

            assertThat(e.getMessage(), is(format("Veículo não encontrado com ID: %s", veiculo.getNumero())));
            assertThat(e.getCause(), is(nullValue()));

            verify(repository).findById(veiculo.getNumero());
            verifyNoMoreInteractions(repository);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    void deveExcluirVeiculoComSucesso() {
        veiculo = new Veiculo(1L, "NTX125", "Bruno", "Ônibus Modelo A", java.sql.Date.valueOf("2000-07-25"), 45);

        doNothing().when(repository).deleteById(veiculo.getNumero());

        service.delete(veiculo.getNumero());

        verify(repository).deleteById(veiculo.getNumero());
        verifyNoMoreInteractions(repository);
    }
}