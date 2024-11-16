package com.ligjet.controlecliente.passagens.controller;

import com.ligjet.controlecliente.passagens.entity.Cidade;
import com.ligjet.controlecliente.passagens.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Anotação do framework Spring dizendo que é aqui a classe que será utilizada os principios de uma API REST
@RequestMapping("/doisv/cidade")//Endpoint padrão da aplicação da ordem de servico
public class CidadeController {

    @Autowired// Injeção de dependencia, significando que o controller e o service dependem um do outro
    private CidadeService cidadeService;


    @GetMapping("/cidades")//Utilizando o protocolo http do API REST para realizar operações como o GET (mostrar dados)
    public List<Cidade> findAllCidades(){
        return cidadeService.findAllCidades();//função feita no service para mostrar todos os servicos;
    }
    @GetMapping(value = "/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o GET (mostrar dados)
    public ResponseEntity <Cidade> findById(@PathVariable String id){//Anotação do framework Spring
        Cidade ci = cidadeService.findById(id);//função feita no service para localizar o id;
        return ResponseEntity.ok().body(ci);//função do framework
    }
    @PostMapping("/create")//Utilizando o protocolo http do API REST para realizar operações como o POST (incluir dados)
    public ResponseEntity<Cidade> criarCidade(@RequestBody Cidade cidade) {
       cidadeService.save1(cidade.getIdCidade(),cidade.getNomeCidade(), cidade.getUf(), cidade.getCep());
       return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
    }

    @PutMapping("/create/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o PUT (alterar dados)
    public void putCidade(@RequestBody Cidade cidade, @PathVariable String id) {//Anotações do framework Spring
       cidadeService.save(cidade.getIdCidade(),cidade.getNomeCidade(), cidade.getUf(), cidade.getCep());
    }

    @DeleteMapping("/delete/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o DELETE (excluir dados)
    public void delete (@PathVariable String id){//Anotação do framework Spring
       cidadeService.delete(id);//função feita no service para deletar os dados
    }
}
