package com.ligjet.controlecliente.passagens.service.impl;

import com.ligjet.controlecliente.passagens.entity.Cidade;
import com.ligjet.controlecliente.passagens.entity.Veiculo;
import com.ligjet.controlecliente.passagens.repository.CidadeRepository;
import com.ligjet.controlecliente.passagens.repository.VeiculoRepository;
import com.ligjet.controlecliente.passagens.service.CidadeService;
import com.ligjet.controlecliente.passagens.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service//Anotação do framework Spring
public class VeiculoServiceImpl implements VeiculoService {

    //Essa classe será usada para lidar com operações de persistência no banco de dados relacional

    @Autowired//A injeção de dependencia fazendo com que o service seja dependente do repository para implementar os dados
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAllVeiculos() {//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET
        return veiculoRepository.findAll();//Esse "findAll();" é graças ao Spring Data que já fornece o método
    }

    public Veiculo findById(Long id){//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET (pelo ID)
        Optional <Veiculo> veiculo = veiculoRepository.findById(id);//Esse "findById();" é graças ao Spring Data que já fornece o método
        return veiculo.get();
    }

   //Sobrescreve o método pois tem o mesmo nome, mas com os parâmetros diferentes
    @Override
    public void save(String placa, String motorista, String modelo, Date dataCompra, int quantidadePoltronas) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como POST
        Veiculo veiculo = new Veiculo(); // Cria uma nova instância da Cidade

        // Define os atributos da nova cidade
        veiculo.setPlaca(placa);
        veiculo.setMotorista(motorista);
        veiculo.setModelo(modelo);

        SimpleDateFormat Sdf = new SimpleDateFormat("yyyy-MM-dd");

        veiculo.setDataCompra((java.sql.Date) dataCompra);
        veiculo.setQtdPoltronas(quantidadePoltronas);

        // Salva a cidade no banco de dados
        veiculoRepository.save(veiculo);
    }


    @Override
    public void save(Long id, String placa, String motorista, String modelo, Date dataCompra, int quantidadePoltronas) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como PUT (Por conta do ID)
       Veiculo veiculo;

        if (id != null) {
            veiculo = veiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Veiculo não encontrado com ID: " + id));
        } else {// Caso não tenha ID, cria uma nova Cidade
            veiculo = new Veiculo();
        }

        // Atualiza os dados do cliente
        veiculo.setPlaca(placa);
        veiculo.setMotorista(motorista);
        veiculo.setModelo(modelo);

        // Define o fuso horário de Brasília
        ZoneId zonaBrasilia = ZoneId.of("America/Sao_Paulo");

        // Converte a dataCompra para LocalDate considerando o fuso horário
        LocalDate localDateCompra = dataCompra.toInstant()
                .atZone(zonaBrasilia) // Aplica o fuso horário
                .toLocalDate(); // Mantém a data sem tempo


        veiculo.setDataCompra((java.sql.Date) dataCompra);
        veiculo.setQtdPoltronas(quantidadePoltronas);

        // Salva a cidade no banco de dados
        veiculoRepository.save(veiculo);
    }

    public void delete(Long id){//esse "delete" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como DELETE
        Veiculo veiculo = new Veiculo();
        veiculoRepository.deleteById(id);//Esse "deleteById();" é graças ao Spring Data que já fornece o método
    }

}
