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
public class Cero extends CaracterAbstraction{
    
    public Cero(int size, CaracterImplementor ci) {
        super(size, ci);
    }

    @Override
    public String[][] getMatrizCaracter() {
        return ci.getDigitoCero(size);
    }
}
