package com.ligjet.controlecliente.passagens.controller;

import com.ligjet.controlecliente.passagens.entity.Cidade;
import com.ligjet.controlecliente.passagens.entity.Veiculo;
import com.ligjet.controlecliente.passagens.service.CidadeService;
import com.ligjet.controlecliente.passagens.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Anotação do framework Spring dizendo que é aqui a classe que será utilizada os principios de uma API REST
@RequestMapping("/doisv/veiculo")//Endpoint padrão da aplicação da ordem de servico
public class VeiculoController {

    @Autowired// Injeção de dependencia, significando que o controller e o service dependem um do outro
    private VeiculoService veiculoService;


    @GetMapping("/veiculos")//Utilizando o protocolo http do API REST para realizar operações como o GET (mostrar dados)
    public List<Veiculo> findAllVeiculos(){
        return veiculoService.findAllVeiculos();//função feita no service para mostrar todos os servicos;
    }
    @GetMapping(value = "/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o GET (mostrar dados)
    public ResponseEntity <Veiculo> findById(@PathVariable Long id){//Anotação do framework Spring
        Veiculo veiculo = veiculoService.findById(id);//função feita no service para localizar o id;
        return ResponseEntity.ok().body(veiculo);//função do framework
    }
    @PostMapping("/create")//Utilizando o protocolo http do API REST para realizar operações como o POST (incluir dados)
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo) {
       veiculoService.save(veiculo.getPlaca(), veiculo.getMotorista(), veiculo.getModelo(), veiculo.getDataCompra(),veiculo.getQtdPoltronas());
       return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    @PutMapping("/create/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o PUT (alterar dados)
    public ResponseEntity<Veiculo> putVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long id) {//Anotações do framework Spring
       veiculoService.save(veiculo.getNumero(),veiculo.getPlaca(), veiculo.getMotorista(), veiculo.getModelo(), veiculo.getDataCompra(),veiculo.getQtdPoltronas());
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);

    }

    @DeleteMapping("/delete/{id}")//Utilizando o protocolo http do API REST para realizar operações para 1 ID em específico com o DELETE (excluir dados)
    public void delete (@PathVariable Long id){//Anotação do framework Spring
       veiculoService.delete(id);//função feita no service para deletar os dados
    }
}
