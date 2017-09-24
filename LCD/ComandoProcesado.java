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
public class ComandoProcesado {

    private final int size;
    private final String numeroImprimir;
    private final int espacioEntreDig;

    ComandoProcesado(int size, String numeroImprimir, int espacioEntreDig) {
        this.size = size;
        this.numeroImprimir = numeroImprimir;
        this.espacioEntreDig = espacioEntreDig;
    }

    public int getSize() {
        return size;
    }

    public char[] getNumeroImprimir() {
        return numeroImprimir.toCharArray();
    }

    public int getEspacioEntreDig() {
        return espacioEntreDig;
    }

}
