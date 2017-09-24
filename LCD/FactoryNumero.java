/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdrefactor.LCD;

import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class FactoryNumero {

    private ArrayList<CaracterAbstraction> numeroImprimir;
    private static FactoryNumero fn;

    //Método para limpiar el ArrayList de CaracterAbstraction
    private void limpiarArrayList() {
        numeroImprimir.clear();
    }

    private FactoryNumero() {
        numeroImprimir = new ArrayList<>();
    }

    //Método del Singleton
    public static FactoryNumero getInstance() {
        if (fn == null) {
            fn = new FactoryNumero();
        }
        return fn;

    }

    //Método factory para crear el objeto CaracterAbstraction del caracter indicado
    private CaracterAbstraction crearCaracter(char caracter, int size) {
        switch (caracter) {
            case '1':
                return new Uno(size, new SieteSegmentos());
            case '2':
                return new Dos(size, new SieteSegmentos());
            case '3':
                return new Tres(size, new SieteSegmentos());
            case '4':
                return new Cuatro(size, new SieteSegmentos());
            case '5':
                return new Cinco(size, new SieteSegmentos());
            case '6':
                return new Seis(size, new SieteSegmentos());
            case '7':
                return new Siete(size, new SieteSegmentos());
            case '8':
                return new Ocho(size, new SieteSegmentos());
            case '9':
                return new Nueve(size, new SieteSegmentos());
            case '0':
                return new Cero(size, new SieteSegmentos());
            default:
//                throw new IllegalArgumentException("Caracter " + caracter
//                        + " no es un digito");
                return null;
        }
    }

    //Método para agregar los caracteres al ArrayList, 
    //recibe el comando procesado (size, numero a imprimir, etc)
    //y utiliza el método factory para crear los objetos necesarios
    private void agregarCaracteres(ComandoProcesado cp) {
        char[] caracteres = cp.getNumeroImprimir();
        for (char caracter : caracteres) {
            //Valida que el caracter sea un digito
            if (!Character.isDigit(caracter)) {
                throw new IllegalArgumentException("Caracter " + caracter
                        + " no es un digito");
            }
            numeroImprimir.add(crearCaracter(caracter, cp.getSize()));
        }
    }

    //Método público que recibe el Comando procesado, limpia el ArrayList,
    //agrega al ArrayList los objetos de los caracteres a imprimir
    //Y retorna una matriz armada con las matrices individuales de cada caracter
    public String[][] getMatrizImpresion(ComandoProcesado cp) {
        limpiarArrayList();
        agregarCaracteres(cp);
        return llenarMatriz(cp);
    }

    //Crea e inicia y retorna la matriz completa de impresión
    private String[][] inicializarMatriz(int espacioEntreChar) {
        int filas = getTotalFilas();
        int columnas = getTotalColumnas(espacioEntreChar);
        String[][] matriz = new String[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                matriz[fila][columna] = " ";
            }
        }
        return matriz;
    }

    //Este método ingresa los valores de cada matriz de Caracter ubicado en el ArrayList
    //en la matriz que representa la impresión del LCD como tal
    private String[][] llenarMatriz(ComandoProcesado cp) {
        String[][] matriz = inicializarMatriz(cp.getEspacioEntreDig());
        int puntoRefX = 0;
        for (int numeroMatriz = 0; numeroMatriz < numeroImprimir.size(); numeroMatriz++) {
            for (int fila = 0; fila < getTotalFilas(); fila++) {
                int columnaDig = 0;
                for (int columna = puntoRefX; columna < puntoRefX + getColumnasPorChar(numeroMatriz); columna++) {
                    matriz[fila][columna] = numeroImprimir.get(numeroMatriz).getMatrizCaracter()[fila][columnaDig];
                    columnaDig++;
                }
            }
            puntoRefX = puntoRefX + getColumnasPorChar(numeroMatriz) + cp.getEspacioEntreDig();
        }
        return matriz;
    }

    private int getFilasPorChar(int caracter) {
        return numeroImprimir.get(caracter).getFilas();
    }

    private int getColumnasPorChar(int caracter) {
        return numeroImprimir.get(caracter).getColumnas();
    }

    private int getTotalFilas() {
        return getFilasPorChar(0);
    }

    //Método que calcula el total de columnas de la matriz de impresión del LCD
    //Recibe el espacio entre caracteres, pues depende de este valor
    private int getTotalColumnas(int espacioEntreChar) {
        int columnas = 0;
        for (int caracter = 0; caracter < numeroImprimir.size(); caracter++) {
            columnas = columnas + getColumnasPorChar(caracter) + espacioEntreChar;
        }
        return columnas;
    }
}
