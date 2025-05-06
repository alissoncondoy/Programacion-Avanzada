/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Presentacion;

import com.mycompany.Persistencias.CelularJpaController;
import com.mycompany.Persistencias.ClienteJpaController;
import com.mycompany.Persistencias.RecargaJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author InnoVausuario
 */
public class CreadorTablas {
    private final EntityManagerFactory emf;

    // Constructor para inicializar el EntityManagerFactory
    public CreadorTablas() {
        this.emf = Persistence.createEntityManagerFactory("MyPU"); // Cambia "MyPU" por el nombre de tu unidad de persistencia
    }

    // Método para crear las tablas inicializando los controladores JPA
    public void crearTablas() {
        try {
            CelularJpaController jpaCelular = new CelularJpaController(emf);
            ClienteJpaController jpaCliente = new ClienteJpaController(emf);
            RecargaJpaController jpaRecarga = new RecargaJpaController(emf);
            System.out.println("Tablas creadas exitosamente (si estaban configuradas para crearse).");
        } catch (Exception e) {
            System.err.println("Error al crear tablas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para obtener el EntityManagerFactory
    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    // Método principal para pruebas independientes
    public static void main(String[] args) {
        CreadorTablas creador = new CreadorTablas();
        creador.crearTablas();
    }
}
