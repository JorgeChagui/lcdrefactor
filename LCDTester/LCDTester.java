/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdrefactor.LCDTester;

import java.util.ArrayList;
import java.util.List;
import lcdrefactor.ImpresorLCD;
import lcdrefactor.LCD.LCD;
import lcdrefactor.LCDManual;

/**
 *
 * @author jorge
 */
public class LCDTester {

    private String resultadoEsperado;
    private String resultadoObtenido;

    public LCDTester() {
        this.resultadoEsperado = "";
        this.resultadoObtenido = "";
    }

    public void ejecutarPrueba(int espacioDig) {

        int pass = 0;
        int fail = 0;
        List<String> listaComando = new ArrayList<>();

        llenarListaComando(listaComando);
        //Se utiliza el ImpresorLCD proporcionado para comparar con el resultado de la solución realizada
        ImpresorLCD impresorLCD = new ImpresorLCD();
        LCD lcd = new LCD();

        int numeroDeComando = 0;
        while (comandoDifCadena(listaComando, numeroDeComando)) {
            //Se obtiene una cadena de la lista para realizar la prueba
            String comando = listaComando.get(numeroDeComando);
            System.out.println("Comando ingresado: "+comando);
            try {
                //Se obtiene la matriz resultado de la solución realizada por mi y se almacena en el resultadoObtenido
                String[][] matriz = lcd.imprimir(comando, espacioDig);
                resultadoObtenido = convertirMatrizAString(matriz);
            } catch (Exception ex) {
                resultadoObtenido = "Error: " + ex.getMessage();
            }
            try {
                //Se obtiene la matriz resultado de la solución original y se almacena en el resultadoEsperado
                String[][] matriz = impresorLCD.procesar(comando, espacioDig);
                resultadoEsperado = convertirMatrizAString(matriz);
            } catch (Exception ex) {
                resultadoEsperado = "Error: " + ex.getMessage();
            }
            if (resultadoEsperado.equals(resultadoObtenido)) {
                pass++;
                imprimirPassPrueba();
            } else {
                fail++;
                imprimirFailPrueba();
            }
            System.out.println("------------------------------------------");
            numeroDeComando++;
        }

        System.out.println("Pass: " + pass);
        System.out.println("Fail: " + fail);

    }

    private void imprimirPassPrueba() {
        System.out.println("Pasó la prueba");
        System.out.println(resultadoObtenido);
    }
    private void imprimirFailPrueba() {
        System.out.println("Falló la prueba");
        System.out.println("Resultado esperado");
        System.out.println(resultadoEsperado);
        System.out.println("Resultado obtenido");
        System.out.println(resultadoObtenido);
    }

    private String convertirMatrizAString(String[][] matriz) {
        String stringMatriz = "";
        int totalFilas = matriz.length;
        int totalColum = matriz[0].length;
        for (int i = 0; i < totalFilas; i++) {
            for (int j = 0; j < totalColum; j++) {
                stringMatriz += matriz[i][j];
            }
            stringMatriz += "\n";
        }
        return stringMatriz;
    }

    private boolean comandoDifCadena(List<String> listaComando, int numeroDeComando) {
        return numeroDeComando != listaComando.indexOf(LCDManual.CADENA_FINAL);
    }

    private void llenarListaComando(List<String> listaComando) {
        listaComando.add("1,123");
        listaComando.add("0,123");
        listaComando.add("2,456");
        listaComando.add("3,");
        listaComando.add("3,789");

        listaComando.add("2,3549");
        listaComando.add(",3549");
        listaComando.add("3,68");
        listaComando.add("1,36921");
        listaComando.add("1921");
        listaComando.add("11,074");

        listaComando.add("3,7");
        listaComando.add("1,67721");
        listaComando.add("1,619,12");
        listaComando.add("10,32");
        listaComando.add("0,0");
    }

    
}
