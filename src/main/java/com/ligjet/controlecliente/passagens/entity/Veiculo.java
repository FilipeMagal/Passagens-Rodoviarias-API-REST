package com.ligjet.controlecliente.passagens.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter//Anotação do Lombok usada para gerar automaticamente método de acesso (get)
@Setter//Anotação do Lombok usada para gerar automaticamente método de modificação (set)
@Entity//Anotação do JPA que define uma entidade persistente
@NoArgsConstructor//Anotação no Lombok usada para gerar automaticamente construtor sem argumentos
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long numero;

    @Column(length = 8, nullable = false)
    private String placa;

    @Column(length = 100, nullable = false)
    private String motorista;

    @Column(length = 50, nullable = false)
    private String modelo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date dataCompra;

    @Column(nullable = false)
    private int qtdPoltronas;

    public Veiculo(Long numero, String placa, String motorista, String modelo, Date dataCompra, int qtdPoltronas) {
        this.numero = numero;
        this.placa = placa;
        this.motorista = motorista;
        this.modelo = modelo;
        this.dataCompra = dataCompra;
        this.qtdPoltronas = qtdPoltronas;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getQtdPoltronas() {
        return qtdPoltronas;
    }

    public void setQtdPoltronas(int qtdPoltronas) {
        this.qtdPoltronas = qtdPoltronas;
    }
}
