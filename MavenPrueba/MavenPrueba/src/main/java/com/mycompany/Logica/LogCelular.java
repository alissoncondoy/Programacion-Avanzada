/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Logica;

public class LogCelular {

    public static boolean validarNumero(String numero) {
        return numero != null && numero.matches("\\d{10}");
    }

    public static boolean validarEstado(int estado) {
        return estado == 0 || estado == 1;
    }
}
