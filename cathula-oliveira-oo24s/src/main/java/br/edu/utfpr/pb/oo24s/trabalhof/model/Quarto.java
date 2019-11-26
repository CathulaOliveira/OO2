/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.oo24s.trabalhof.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Cathula
 */
@Entity
@Table(name = "quarto")
public class Quarto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    private Long numero;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoQuarto tipo;
    
    @Column(name = "quantidadecamas")
    private Long quantidadeDeCamas;
    
    @Column(name = "quantidadepessoas")
    private Long quantidadeDePessoas;
    
    @DecimalMin(value = "0.01", 
            message = "O valor da diaria deve ser maior que R$ 0.00.")
    @Column(name = "valordiaria")
    private Double valorDaDiaria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public Long getQuantidadeDeCamas() {
        return quantidadeDeCamas;
    }

    public void setQuantidadeDeCamas(Long quantidadeDeCamas) {
        this.quantidadeDeCamas = quantidadeDeCamas;
    }

    public Long getQuantidadeDePessoas() {
        return quantidadeDePessoas;
    }

    public void setQuantidadeDePessoas(Long quantidadeDePessoas) {
        this.quantidadeDePessoas = quantidadeDePessoas;
    }

    public Double getValorDaDiaria() {
        return valorDaDiaria;
    }

    public void setValorDaDiaria(Double valorDaDiaria) {
        this.valorDaDiaria = valorDaDiaria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Quarto other = (Quarto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quarto{" + "id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", quantidadeDeCamas=" + quantidadeDeCamas + ", quantidadeDePessoas=" + quantidadeDePessoas + ", valorDaDiaria=" + valorDaDiaria + '}';
    }
    
    
}
