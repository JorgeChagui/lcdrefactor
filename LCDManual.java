package lcdrefactor;

import lcdrefactor.LCD.LCD;
import lcdrefactor.LCD.LectorEntrada;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDManual {

    public static final String CADENA_FINAL = "0,0";

    public LCDManual() {
    }

    public void ejecutar() {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        String comando;
        int espacioDig = 0;

        try {

            try {
                Scanner lector = new Scanner(System.in);
                System.out.print("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();

                // Valida si es un numero
                espacioDig = LectorEntrada.validarEspacio(comando);
                
                do {
                    System.out.print("Entrada: ");
                    comando = lector.next();
                    if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
                        listaComando.add(comando);
                    }
                } while (!comando.equalsIgnoreCase(CADENA_FINAL));
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }

            LCD lcd = new LCD();

            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) {
                try {
                    imprimirMatriz(lcd.imprimir(iterator.next(), espacioDig));
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    public void imprimirMatriz(String[][] matriz) {
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
