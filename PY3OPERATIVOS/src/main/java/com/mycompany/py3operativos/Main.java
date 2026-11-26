/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.py3operativos;

import java.io.File;

/**
 * Punto de entrada principal de la aplicación del sistema de archivos.
 * <p>
 * Procesa los argumentos de línea de comandos para iniciar la consola sin disco
 * o validar la existencia y extensión ({@code .fs}) de un disco antes de iniciar
 * la ejecución.
 * </p>
 *
 * @author Deislher Sánchez Funez
 * @author Natalia Granados Rosales
 */
public class Main {

    /**
     * Ejecuta la aplicación según los argumentos recibidos por línea de comandos.
     * <p>
     * Sin argumentos inicia la consola directamente. Con un argumento valida que
     * tenga extensión {@code .fs} y corresponda a un archivo existente antes de
     * asignarlo a la consola e iniciarla. Con más de un argumento informa un error.
     * </p>
     *
     * @param args argumentos de línea de comandos; opcionalmente el nombre o ruta de un archivo de disco {@code .fs}.
     */
    public static void main(String[] args) {
        Consola consola = new Consola();
        switch (args.length) {
            case 0 ->
                consola.iniciar();
            case 1 -> {
                String nombreDisco = args[0];
                if (!nombreDisco.endsWith(".fs")) {
                    System.out.println("Error: La extensión debe ser .fs");
                    return;
                }
                File disco = new File(nombreDisco);
                if (!disco.isFile()) {
                    System.out.println("Error: El disco no existe.");
                    return;
                }
                // Pendiente: validar y cargar las estructuras del disco.
                consola.setNombreDisco(nombreDisco);
                consola.iniciar();
            }
            default ->
                System.out.println("Error: Cantidad de argumentos inválida.");
        }
    }
}
