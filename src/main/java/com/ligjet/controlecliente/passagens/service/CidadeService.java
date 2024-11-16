package com.ligjet.controlecliente.passagens.service;

import com.ligjet.controlecliente.passagens.entity.Cidade;
import org.springframework.stereotype.Service;
import java.util.List;

@Service//Anotação do framework Spring
public interface CidadeService {//Interface para criar as regras da aplicação
    List<Cidade> findAllCidades();//Método que deverá ser implementado por outra classe (GET)

    Cidade findById (String id);//Método que deverá ser implementado pelas classes(GET)

    void save (String idCidade, String nomeCidade, String uf, String cep);//Método que deverá ser implementado pelas classes (PUT)
    void save1 (String idCidade, String nomeCidade, String uf, String cep);//Método que deverá ser implementado pelas classes (PUT)

    void delete (String id);//Método que deverá ser implementado pelas classes (DELETE)

}
