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

    //Método para imprimir la salida del LCD
    public void imprimir(String entrada, int espacioEntreDig) {
        ComandoProcesado lcdc = lectorEntrada.procesar(entrada, espacioEntreDig);
        FactoryNumero factoria = FactoryNumero.getInstance();
        String[][] matriz = factoria.getMatrizImpresion(lcdc);
        int totalFilas = matriz.length;
        int totalColum = matriz[0].length;
        for (int i = 0; i < totalFilas; i++) {
            for (int j = 0; j < totalColum; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }

    }
}
