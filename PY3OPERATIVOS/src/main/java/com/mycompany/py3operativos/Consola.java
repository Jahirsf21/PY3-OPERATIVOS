/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.py3operativos;

import java.util.Scanner;

/**
 * Consola interactiva de línea de comandos para operar sobre el sistema de archivos.
 * <p>
 * Gestiona el ciclo de lectura y despacho de comandos, la visualización del prompt
 * según el estado de carga del disco y la validación previa de los comandos que
 * requieren un disco cargado.
 * </p>
 *
 * @author Deislher Sánchez Funez
 * @author Natalia Granados Rosales
 */
public class Consola {

    private String nombreUsuario;
    private String nombreDisco;
    private String rutaActual;
    private boolean discoCargado = false;

    /**
     * Muestra en la salida estándar el prompt de la consola.
     * <p>
     * Si hay un disco cargado, despliega el formato
     * {@code usuario@disco:ruta> }; de lo contrario, muestra {@code > }.
     * </p>
     */
    private void mostrarPrompt() {
        if (discoCargado) {
            System.out.printf("%s@%s:%s> ", nombreUsuario, nombreDisco, rutaActual);
        } else {
            System.out.print("> ");
        }
    }

    /**
     * Determina si un comando requiere que exista un disco cargado para ejecutarse.
     *
     * @param comando nombre del comando ingresado por el usuario.
     * @return {@code true} si el comando requiere un disco cargado; {@code false} en caso contrario.
     */
    private boolean requiereDisco(String comando) {
        return switch (comando) {
            case "useradd", "groupadd", "passwd", "su", "whoami", "pwd", "mkdir", "rm", "mv", "ls", "cd", "whereis", "ln", "touch", "cat", "less", "chown", "chgrp", "chmod", "viewFilesOpen", "viewFCB", "infoFS", "note" ->
                true;
            default ->
                false;
        };
    }

    /**
     * Inicia el ciclo principal de ejecución de la consola interactiva.
     * <p>
     * Lee comandos desde la entrada estándar, valida si requieren un disco cargado
     * y despacha cada comando reconocido hasta recibir {@code exit} o alcanzar
     * el fin de la entrada.
     * </p>
     */
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean enEjecucion = true;
        while (enEjecucion) {
            mostrarPrompt();
            if (!scanner.hasNextLine()) {
                break;
            }
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                continue;
            }
            String[] partes = entrada.split("\\s+");
            String comando = partes[0];
            if (!discoCargado && requiereDisco(comando)) {
                System.out.println("Error: no hay un disco cargado.");
                continue;
            }
            switch (comando) {
                case "exit" ->
                    enEjecucion = false;
                case "format" -> {
                }
                case "useradd" -> {
                }
                case "groupadd" -> {
                }
                case "passwd" -> {
                }
                case "su" -> {
                }
                case "whoami" -> {
                }
                case "pwd" -> {
                }
                case "mkdir" -> {
                }
                case "rm" -> {
                }
                case "mv" -> {
                }
                case "ls" -> {
                }
                case "clear" -> {
                }
                case "cd" -> {
                }
                case "whereis" -> {
                }
                case "ln" -> {
                }
                case "touch" -> {
                }
                case "cat" -> {
                }
                case "less" -> {
                }
                case "chown" -> {
                }
                case "chgrp" -> {
                }
                case "chmod" -> {
                }
                case "viewFilesOpen" -> {
                }
                case "viewFCB" -> {
                }
                case "infoFS" -> {
                }

                case "note" -> {
                }
                default ->
                    System.out.println("\"" + comando + "\" no se reconoce como un comando interno.");
            }
        }
        scanner.close();
    }

    /**
     * Establece el nombre del usuario activo que se mostrará en el prompt.
     *
     * @param nombreUsuario nombre del usuario actual.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Establece el nombre del disco actual que se mostrará en el prompt.
     *
     * @param nombreDisco nombre o ruta del archivo de disco.
     */
    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    /**
     * Marca el estado de la consola indicando que ya existe un disco cargado.
     */
    public void setDiscoCargado() {
        this.discoCargado = true;
    }

    /**
     * Establece la ruta del directorio actual que se mostrará en el prompt.
     *
     * @param rutaActual ruta del directorio de trabajo actual.
     */
    public void setRutaActual(String rutaActual) {
        this.rutaActual = rutaActual;
    }

}
