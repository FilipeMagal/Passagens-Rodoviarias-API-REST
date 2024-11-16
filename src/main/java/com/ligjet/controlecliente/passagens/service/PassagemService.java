package com.ligjet.controlecliente.passagens.service;

import com.ligjet.controlecliente.passagens.entity.Cidade;
import com.ligjet.controlecliente.passagens.entity.Passagem;
import com.ligjet.controlecliente.passagens.entity.Veiculo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service//Anotação do framework Spring
public interface PassagemService {//Interface para criar as regras da aplicação
    List<Passagem> findAllPassagens();//Método que deverá ser implementado por outra classe (GET)

    Passagem findById(Long id);//Método que deverá ser implementado pelas classes(GET)

    void save(Long id, Veiculo veiculo, int poltrona, Date dataSaida, String horaSaida, Cidade cidadeOrigemId, Cidade cidadeDestinoId, BigDecimal valorPassagem); //Método que deverá ser implementado pelas classes (PUT)
    void save(Veiculo veiculo, int poltrona, Date dataSaida, String horaSaida, Cidade cidadeOrigemId, Cidade cidadeDestinoId, BigDecimal valorPassagem); //Método que deverá ser implementado pelas classes (POST)

    void delete(Long id);//Método que deverá ser implementado pelas classes (DELETE)
}
