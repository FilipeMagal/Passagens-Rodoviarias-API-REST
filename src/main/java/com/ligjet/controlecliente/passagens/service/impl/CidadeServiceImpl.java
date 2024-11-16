package com.ligjet.controlecliente.passagens.service.impl;

import com.ligjet.controlecliente.passagens.entity.Cidade;

import com.ligjet.controlecliente.passagens.repository.CidadeRepository;
import com.ligjet.controlecliente.passagens.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service//Anotação do framework Spring
public class CidadeServiceImpl implements CidadeService {

    //Essa classe será usada para lidar com operações de persistência no banco de dados relacional

    @Autowired//A injeção de dependencia fazendo com que o service seja dependente do repository para implementar os dados
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAllCidades() {//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET
        return cidadeRepository.findAll();//Esse "findAll();" é graças ao Spring Data que já fornece o método
    }

    public Cidade findById(String id){//esse é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como GET (pelo ID)
        Optional <Cidade> ci = cidadeRepository.findById(id);//Esse "findById();" é graças ao Spring Data que já fornece o método
        return ci.get();
    }

   //Sobrescreve o método pois tem o mesmo nome, mas com os parâmetros diferentes
    @Override
    public void save1(String idCidade, String nomeCidade, String uf, String cep) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como POST
        Cidade cidade = new Cidade(); // Cria uma nova instância da Cidade

        // Define os atributos da nova cidade
        cidade.setIdCidade(idCidade);
        cidade.setNomeCidade(nomeCidade);
        cidade.setUf(uf);
        cidade.setCep(cep);

        // Salva a cidade no banco de dados
        cidadeRepository.save(cidade);
    }


    @Override
    public void save(String idCidade, String nomeCidade, String uf, String cep) {//esse "save" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como PUT (Por conta do ID)
       Cidade cidade;

    if (idCidade != null && !idCidade.trim().isEmpty()) {//.trim remove todos os espaços em branco
        cidade = cidadeRepository.findById(idCidade).orElseThrow(() -> new RuntimeException("Cidade não encontrada com ID: " + idCidade));
    } else {// Caso não tenha ID, cria uma nova Cidade
        throw new RuntimeException("Cidade não encontrada com ID: " + idCidade);
    }

        // Atualiza os dados do cliente
        cidade.setNomeCidade(nomeCidade);
        cidade.setUf(uf);
        cidade.setCep(cep);

        // Salva o cliente no banco de dados
        cidadeRepository.save(cidade);//Esse "save" é graças ao Spring Data que já fornece o método
    }

    public void delete(String id){//esse "delete" é um método que nós definimos lá na interface service que está sendo implementada nessa classe que iremos usar no controller como DELETE
        Cidade cidade = new Cidade();
        cidadeRepository.deleteById(id);//Esse "deleteById();" é graças ao Spring Data que já fornece o método
    }

}
