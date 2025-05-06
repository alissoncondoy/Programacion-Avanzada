/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Recarga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idRecarga;
    private int valor;
    private int saldo;
    private int megaDolar;

    @OneToOne
    private Celular celular;

    public Recarga() {
    }

    public Recarga(int idRecarga, int valor, int saldo, int megaDolar) {
        this.idRecarga = idRecarga;
        this.valor = valor;
        this.saldo = saldo;
        this.megaDolar = megaDolar;
    }

    // Getters and Setters
    public int getIdRecarga() {
        return idRecarga;
    }

    public void setIdRecarga(int idRecarga) {
        this.idRecarga = idRecarga;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getMegaDolar() {
        return megaDolar;
    }

    public void setMegaDolar(int megaDolar) {
        this.megaDolar = megaDolar;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }
}