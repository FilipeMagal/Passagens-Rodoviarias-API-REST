package com.ligjet.controlecliente.passagens.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter//Anotação do Lombok usada para gerar automaticamente método de acesso (get)
@Setter//Anotação do Lombok usada para gerar automaticamente método de modificação (set)
@Entity//Anotação do JPA que define uma entidade persistente
@NoArgsConstructor//Anotação no Lombok usada para gerar automaticamente construtor sem argumentos
public class Passagem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPassagem;

        @Column(nullable = false)
        private int poltrona;

        @Temporal(TemporalType.DATE)
        @Column(nullable = false)
        private Date dataSaida;

        @Column(length = 5, nullable = false)
        private String horaSaida;

        @Column(nullable = false, precision = 10, scale = 2)
        private BigDecimal valorPassagem;

        @ManyToOne
        @JoinColumn(name = "veiculo", referencedColumnName = "numero")
        private Veiculo veiculo;

        @ManyToOne
        @JoinColumn(name = "cidade_Origem", referencedColumnName = "idCidade")
        private Cidade cidadeOrigem;

        @ManyToOne
        @JoinColumn(name = "cidade_Destino", referencedColumnName = "idCidade")
        private Cidade cidadeDestino;



    public Passagem(Long idPassagem, int poltrona, Date dataSaida, String horaSaida, BigDecimal valorPassagem) {
        this.idPassagem = idPassagem;
        this.poltrona = poltrona;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.valorPassagem = valorPassagem;
    }

    public Long getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(Long idPassagem) {
        this.idPassagem = idPassagem;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public BigDecimal getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(BigDecimal valorPassagem) {
        this.valorPassagem = valorPassagem;
    }
}
