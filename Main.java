/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdrefactor;

import java.util.Scanner;
import lcdrefactor.LCD.LectorEntrada;
import lcdrefactor.LCDTester.LCDTester;

/**
 *
 * @author jorge
 */
public class Main {

    public static void main(String[] args) {
        LCDTester tester = new LCDTester();
        LCDManual manual = new LCDManual();
        String comando;
        int opcion=0;
        Scanner lector = new Scanner(System.in);

        do {
            try {
                System.out.println("Seleccionar opción: "
                        + "\n 1. Ejecutar LCD manual. "
                        + "\n 2. Ejecutar prueba automáticas."
                        + "\n Salir con cualquier otro número.");
                opcion = lector.nextInt();

                if (opcion == 1) {
                    manual.ejecutar();
                }
                if (opcion == 2) {

                    System.out.print("Espacio entre digitos de prueba, de 0 a 5: ");
                    comando = lector.next();
                    int espacioEntreDigito = LectorEntrada.validarEspacio(comando);
                    tester.ejecutarPrueba(espacioEntreDigito);

                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } while (opcion == 1 || opcion == 2);

    }
}
