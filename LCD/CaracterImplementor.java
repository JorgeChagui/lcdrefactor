/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdrefactor.LCD;

/**
 *
 * @author jorge
 */
public abstract class CaracterImplementor {

    //Crea una matriz inicializada, dado el número de filas y el número de columnas
    protected String[][] crearMatriz(int filas, int columnas) {
        String[][] matriz = new String[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                matriz[fila][columna] = " ";
            }
        }
        return matriz;
    }

    //Métodos para calcular Filas y columnas por defecto del SieteSegmentos.
    public int getFilas(int size) {
        return (2 * size) + 3;
    }

    public int getColumnas(int size) {
        return size + 2;
    }

    public CaracterImplementor() {

    }
    //métodos para agregar los caracteres de los segmentos en la matriz para cada Digito

    public abstract String[][] getDigitoUno(int size);

    public abstract String[][] getDigitoDos(int size);

    public abstract String[][] getDigitoTres(int size);

    public abstract String[][] getDigitoCuatro(int size);

    public abstract String[][] getDigitoCinco(int size);

    public abstract String[][] getDigitoSeis(int size);

    public abstract String[][] getDigitoSiete(int size);

    public abstract String[][] getDigitoOcho(int size);

    public abstract String[][] getDigitoNueve(int size);

    public abstract String[][] getDigitoCero(int size);
}
