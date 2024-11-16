package com.ligjet.controlecliente.passagens.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter//Anotação do Lombok usada para gerar automaticamente método de acesso (get)
@Setter//Anotação do Lombok usada para gerar automaticamente método de modificação (set)
@Entity//Anotação do JPA que define uma entidade persistente
@NoArgsConstructor//Anotação no Lombok usada para gerar automaticamente construtor sem argumentos
public class Cidade {

        @Id
        @Column(length = 10)
        private String idCidade;

        @Column(length = 50, nullable = false)
        private String nomeCidade;

        @Column(length = 2, nullable = false)
        private String uf;

        @Column(length = 9, nullable = false, unique = true)
        private String cep;

        public Cidade(String idCidade, String nomeCidade, String uf, String cep) {
            this.idCidade = idCidade;
            this.nomeCidade = nomeCidade;
            this.uf = uf;
            this.cep = cep;
        }

        public String getIdCidade() {
            return idCidade;
        }

        public void setIdCidade(String idCidade) {
            this.idCidade = idCidade;
        }

        public String getNomeCidade() {
            return nomeCidade;
        }

        public void setNomeCidade(String nomeCidade) {
            this.nomeCidade = nomeCidade;
        }

        public String getUf() {
            return uf;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }
    }


