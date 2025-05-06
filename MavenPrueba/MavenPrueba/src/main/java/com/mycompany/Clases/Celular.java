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
public class Celular implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCelular;
    private String numero;
    private int estado;
    private int saldo;
    private int megas;

    @OneToOne
    private Cliente cliente;

    @OneToOne(mappedBy = "celular")
    private Recarga recarga;

    public Celular() {
    }

    public Celular(int idCelular, String numero, int estado, int saldo, int megas) {
        this.idCelular = idCelular;
        this.numero = numero;
        this.estado = estado;
        this.saldo = saldo;
        this.megas = megas;
    }

    // Getters and Setters
    public int getIdCelular() {
        return idCelular;
    }

    public void setIdCelular(int idCelular) {
        this.idCelular = idCelular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getMegas() {
        return megas;
    }

    public void setMegas(int megas) {
        this.megas = megas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Recarga getRecarga() {
        return recarga;
    }

    public void setRecarga(Recarga recarga) {
        this.recarga = recarga;
    }
}
