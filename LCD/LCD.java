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
public class LCD {

    private LectorEntrada lectorEntrada;

    public LCD() {
        lectorEntrada = new LectorEntrada();
    }

    //Método para generar la salida del LCD
    public String[][] imprimir(String entrada, int espacioEntreDig) {
        ComandoProcesado lcdc = lectorEntrada.procesar(entrada, espacioEntreDig);
        FactoryNumero factoria = FactoryNumero.getInstance();
        String[][] matriz = factoria.getMatrizImpresion(lcdc);
        return matriz;
    }
}
