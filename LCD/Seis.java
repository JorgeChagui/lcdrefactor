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
public class Seis extends CaracterAbstraction{
    
    public Seis(int size, CaracterImplementor ci) {
        super(size, ci);
    }

    @Override
    public String[][] getMatrizCaracter() {
        return ci.getDigitoSeis(size);
    }
}
