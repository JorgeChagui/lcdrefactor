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
public abstract class CaracterAbstraction {

    protected CaracterImplementor ci;
    protected final int size;
    protected String[][] matriz;

    public CaracterAbstraction(int size, CaracterImplementor ci) {
        this.size = size;
        this.ci = ci;
    }

    public int getFilas() {
        return ci.getFilas(size);
    }

    public int getColumnas() {
        return ci.getColumnas(size);
    }

    public abstract String[][] getMatrizCaracter();

}
