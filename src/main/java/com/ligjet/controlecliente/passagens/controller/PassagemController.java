package com.ligjet.controlecliente.passagens.controller;

import com.ligjet.controlecliente.passagens.entity.Passagem;
import com.ligjet.controlecliente.passagens.service.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Anotação do framework Spring dizendo que é aqui a classe que será utilizada os principios de uma API REST
@RequestMapping("/doisv/passagem") //Endpoint padrão da aplicação da passagem
public class PassagemController {
    @Autowired // Injeção de dependencia, significando que o controller e o service dependem um do outro (para ultilizar os métodos imposto)
    private PassagemService passagemService;

    @GetMapping("/passagens")//Utilizando o protocolo http do API REST para realizar operações como o GET (mostrar dados)
    public List<Passagem> findAllPassagens(){
        return passagemService.findAllPassagens();//função feita no service para mostrar todos os clientes;
    }

    @GetMapping(value = "/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o GET (mostrar dados)
    public ResponseEntity <Passagem> findById(@PathVariable Long id){ //Anotação do framework Spring
        Passagem obj = passagemService.findById(id); //função feita no service para localizar o id;
        return ResponseEntity.ok().body(obj);//função do framework
    }

    @PostMapping("/create")//Utilizando o protocolo http do API REST para realizar operações como o POST (incluir dados)
    public void createPassagem(@RequestBody Passagem passagem) {//Anotação do framework Spring
        passagemService.save(
                passagem.getVeiculo(),  // Número do veículo (ou qualquer método apropriado para obter a identificação)
                passagem.getPoltrona(),             // Número da poltrona
                passagem.getDataSaida(), // Data de saída (convertida para String, se necessário)
                passagem.getHoraSaida(),            // Hora de saída
                passagem.getCidadeOrigem(), // ID da cidade de origem
                passagem.getCidadeDestino(), // ID da cidade de destino
                passagem.getValorPassagem()         // Valor da passagem
        );
    }

    @PutMapping("/create/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o PUT (alterar dados)
    public void putPassagem(@RequestBody Passagem passagem, @PathVariable Long id) {//Anotações do framework Spring
        passagemService.save(
                passagem.getIdPassagem(),
                passagem.getVeiculo(),  // Número do veículo (ou qualquer método apropriado para obter a identificação)
                passagem.getPoltrona(),             // Número da poltrona
                passagem.getDataSaida(), // Data de saída (convertida para String, se necessário)
                passagem.getHoraSaida(),            // Hora de saída
                passagem.getCidadeOrigem(), // ID da cidade de origem
                passagem.getCidadeDestino(), // ID da cidade de destino
                passagem.getValorPassagem()         // Valor da passagem
        );    }

    @DeleteMapping("/delete/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o DELETE (excluir dados)
    public void  delete(@PathVariable Long id) {//Anotação do framework Spring
        passagemService.delete(id);//função feita no service para deletar os dados
    }
}