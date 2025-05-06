/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Logica;

/**
 *
 * 
 */
public class LogPropietario {

    public static boolean validarCedula(String cedula) {
        // Verifica que no sea nula, que tenga 4 caracteres y que todos sean dígitos
        return cedula != null && cedula.matches("\\d{4}");
    }

}
