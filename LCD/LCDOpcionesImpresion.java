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
public class LCDOpcionesImpresion {

    private final String valor;
    public static final LCDOpcionesImpresion CARACTER_VERTICAL = new LCDOpcionesImpresion("|");
    public static final LCDOpcionesImpresion CARACTER_HORIZONTAL = new LCDOpcionesImpresion("-");
    public static final LCDOpcionesImpresion POSICION_X = new LCDOpcionesImpresion("X");
    public static final LCDOpcionesImpresion POSICION_Y = new LCDOpcionesImpresion("Y");

    @Override
    public String toString() {
        return valor;
    }

    private LCDOpcionesImpresion(String valor) {
        this.valor = valor;
    }

}
