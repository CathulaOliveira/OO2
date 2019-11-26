/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.oo24s.trabalhof.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

/**
 *
 * @author Cathula
 */
@Entity
@Table(name = "reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name="quarto_id", referencedColumnName = "id")
    private Quarto quarto;
    
    @ManyToOne()
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Cliente responsavel;
    
    @OneToMany(mappedBy = "cliente", orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Cliente> hospedes;
    
    @Column(name = "datareserva")
    private LocalDate dataDaReserva;
    
    @Column(name = "dataentrada")
    private LocalDate dataDeEntrada;
    
    @Column(name = "datasaida")
    private LocalDate dataDeSaida;
    
    @Column(name = "motivohospedagem")
    private String motivoDaHospedagem;
    
    @DecimalMin(value = "0.01", 
            message = "O valor deve ser maior que R$ 0.00.")
    @Column(name = "valor")
    private Double valorDaDiaria;
    
    @OneToMany(mappedBy = "produto", orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Produto> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Cliente getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Cliente responsavel) {
        this.responsavel = responsavel;
    }

    public List<Cliente> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Cliente> hospedes) {
        this.hospedes = hospedes;
    }

    public LocalDate getDataDaReserva() {
        return dataDaReserva;
    }

    public void setDataDaReserva(LocalDate dataDaReserva) {
        this.dataDaReserva = dataDaReserva;
    }

    public LocalDate getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(LocalDate dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public LocalDate getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(LocalDate dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    public String getMotivoDaHospedagem() {
        return motivoDaHospedagem;
    }

    public void setMotivoDaHospedagem(String motivoDaHospedagem) {
        this.motivoDaHospedagem = motivoDaHospedagem;
    }

    public Double getValorDaDiaria() {
        return valorDaDiaria;
    }

    public void setValorDaDiaria(Double valorDaDiaria) {
        this.valorDaDiaria = valorDaDiaria;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", quarto=" + quarto + ", responsavel=" + responsavel + ", hospedes=" + hospedes + ", dataDaReserva=" + dataDaReserva + ", dataDeEntrada=" + dataDeEntrada + ", dataDeSaida=" + dataDeSaida + ", motivoDaHospedagem=" + motivoDaHospedagem + ", valorDaDiaria=" + valorDaDiaria + ", produtos=" + produtos + '}';
    }
    
}
