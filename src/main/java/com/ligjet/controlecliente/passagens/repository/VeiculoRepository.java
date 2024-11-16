package com.ligjet.controlecliente.passagens.repository;

import com.ligjet.controlecliente.passagens.entity.Cidade;
import com.ligjet.controlecliente.passagens.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Anotação do framework indica que a classe é um componente para acesso a dados
public interface VeiculoRepository extends JpaRepository <Veiculo, Long> {
    //Classe feita juntamente com JPA e Spring Data para facilitar a implementação de acesso aos dados com o repositorio
}

