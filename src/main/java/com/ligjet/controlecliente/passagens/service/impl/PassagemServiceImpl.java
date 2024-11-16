package com.ligjet.controlecliente.passagens.service.impl;


import com.ligjet.controlecliente.passagens.entity.Cidade;
import com.ligjet.controlecliente.passagens.entity.Passagem;
import com.ligjet.controlecliente.passagens.entity.Veiculo;
import com.ligjet.controlecliente.passagens.repository.PassagemRepository;
import com.ligjet.controlecliente.passagens.service.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service//Anotação do framework Spring
@Transactional
public class PassagemServiceImpl implements PassagemService { //implements é usado para justamente implementar interfaces

    //Essa classe será usada para lidar com operações de persistência no banco de dados relacional

    @Autowired//A injeção de dependencia fazendo com que o service seja dependente do repository para implementar os dados
    private PassagemRepository passagemRepository;

    public List<Passagem> findAllPassagens() {//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET
        return passagemRepository.findAll();//Esse "findAll();" é graças ao Spring Data que já fornece o método
    }

    public Passagem findById(Long id){//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET (pelo ID)
        Optional<Passagem> cl = passagemRepository.findById(id);//Esse "findById();" é graças ao Spring Data que já fornece o método
        return cl.get();
    }

    public void save(Long id, Veiculo veiculo, int poltrona, Date dataSaida, String horaSaida, Cidade cidadeOrigem, Cidade cidadeDestino, BigDecimal valorPassagem) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como PUT (Por conta do ID)
        Passagem passagem;

        if (id != null) {// Verifica se o ID está presente para decidir entre criar um novo cliente ou atualizar um existente
            passagem = passagemRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " +id));// Busca o cliente existente pelo ID, se ele existir
        } else {// Caso não tenha ID, cria um novo cliente
            throw new RuntimeException("Passagem não encontrada com ID: null");
        }
        // Configurando os dados da entidade Passagem
        passagem.setVeiculo(veiculo); // Associando o veículo
        passagem.setPoltrona(poltrona); // Definindo a poltrona


        java.sql.Date sqlDate = new java.sql.Date(dataSaida.getTime());
        passagem.setDataSaida(sqlDate); // Configurando a data de saída com java.sql.Date
        passagem.setHoraSaida(horaSaida); // Definindo o horário de saída
        passagem.setCidadeOrigem(cidadeOrigem); // Associando a cidade de origem
        passagem.setCidadeDestino(cidadeDestino); // Associando a cidade de destino
        passagem.setValorPassagem(valorPassagem); // Configurando o valor da passagem

        // Salva o cliente no banco de dados
        passagemRepository.save(passagem);//Esse "save" é graças ao Spring Data que já fornece o método
    }

        public void save(Veiculo veiculo, int poltrona, Date dataSaida, String horaSaida, Cidade cidadeOrigem, Cidade cidadeDestino, BigDecimal valorPassagem) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como POST
        Passagem passagem = new Passagem();

        // Configurando os dados da entidade Passagem
        passagem.setVeiculo(veiculo); // Associando o veículo
        passagem.setPoltrona(poltrona); // Definindo a poltrona

        java.sql.Date sqlDate = new java.sql.Date(dataSaida.getTime());
        passagem.setDataSaida(sqlDate); // Configurando a data de saída com java.sql.Date
        passagem.setHoraSaida(horaSaida); // Definindo o horário de saída

        passagem.setCidadeOrigem(cidadeOrigem); // Associando a cidade de origem
        passagem.setCidadeDestino(cidadeDestino); // Associando a cidade de destino
        passagem.setValorPassagem(valorPassagem); // Configurando o valor da passagem

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(passagem.getDataSaida());



        // Salva o cliente no banco de dados
        passagemRepository.save(passagem);//Esse "save" é graças ao Spring Data que já fornece o método
    }


    public void delete(Long id){//esse "delete" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como DELETE
        Passagem passagem = new Passagem();
        passagemRepository.deleteById(id);//Esse "deleteById();" é graças ao Spring Data que já fornece o método
    }
}

